package com.flightmanagement.service;

import com.flightmanagement.domain.BookingRecord;
import com.flightmanagement.domain.Fare;
import com.flightmanagement.domain.Inventory;
import com.flightmanagement.domain.Passenger;
import com.flightmanagement.repository.BookingRepository;
import com.flightmanagement.repository.InventoryRepository;
import com.flightmanagement.util.BookingException;
import com.flightmanagement.util.BookingStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by z00382545 on 11/10/16.
 */

@Service
public class BookingService {
    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);
    private static final String FareURL = "http://localhost:8080/fares";

    BookingRepository bookingRepository;
    InventoryRepository inventoryRepository;

    private RestTemplate restTemplate;

    SenderService senderService;

    @Autowired
    public BookingService (BookingRepository bookingRepository,
                             SenderService senderService,InventoryRepository inventoryRepository){
        this.bookingRepository = bookingRepository;
        this.restTemplate = new RestTemplate();
        this.senderService = senderService;
        this.inventoryRepository = inventoryRepository;
    }

    public long book(BookingRecord record) {
        logger.info("calling fares to get fare");
        Fare fare = restTemplate.getForObject(FareURL + "/get?flightNumber="+record.getFlightNumber()+"&flightDate="+record.getFlightDate(), Fare.class);

        logger.info("calling fares to get fare"+fare);
        if(!record.getFare().equals(fare.getFare())) throw new BookingException("fare is tampered");

        logger.info("calling inventory to get inventory");
        Inventory inventory = inventoryRepository.findByFlightNumberAndFlightDate(record.getFlightNumber(), record.getFlightDate());

        if(!inventory.isAvailable(record.getPassengers().size())) {
            throw new BookingException("No more seats available");
        }

        logger.info("successfully checked inventory"+inventory);
        logger.info("calling inventory to update inventory");

        inventory.setAvailable(inventory.getAvailable() - record.getPassengers().size());
        inventoryRepository.save(inventory);
        logger.info("successfully updated inventory");

        record.setStatus(BookingStatus.BOOKING_CONFIRMED);
        Set<Passenger> passengers = record.getPassengers();
        passengers.forEach(passenger -> passenger.setBookingRecord(record));
        record.setBookingDate(new Date());
        long id = bookingRepository.save(record).getId();
        logger.info("successfully saved booking");

        logger.info("sending a booking event");
        Map<String, Object> bookingDetails = new HashMap<>();
        bookingDetails.put("FLIGHT_NUMBER", record.getFlightNumber());
        bookingDetails.put("FLIGHT_DATE", record.getFlightDate());
        bookingDetails.put("NEW_INVENTORY", inventory.getBookableInventory());
        senderService.send(bookingDetails);
        logger.info("booking event successfully delivered "+ bookingDetails);
        return id;
    }

    public BookingRecord getBooking(long id) {
        return bookingRepository.findOne(id);
    }

    public void updateStatus (String status, long bookingId) {
        BookingRecord record = bookingRepository.findOne(bookingId);
        record.setStatus(status);
    }
}
