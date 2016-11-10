package com.flightmanagement;

import com.flightmanagement.domain.BookingRecord;
import com.flightmanagement.domain.Inventory;
import com.flightmanagement.domain.Passenger;
import com.flightmanagement.repository.BookingRepository;
import com.flightmanagement.repository.InventoryRepository;
import com.flightmanagement.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BookApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(BookApplication.class);
	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private BookingService bookingService;

	@Autowired
	InventoryRepository inventoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		Inventory[] invs = {
				new Inventory("BF100", "22-JAN-16", 100),
				new Inventory("BF101", "22-JAN-16", 100),
				new Inventory("BF102", "22-JAN-16", 100),
				new Inventory("BF103", "22-JAN-16", 100),
				new Inventory("BF104", "22-JAN-16", 100),
				new Inventory("BF105", "22-JAN-16", 100),
				new Inventory("BF106", "22-JAN-16", 100)};
		Arrays.asList(invs).forEach(inventory -> inventoryRepository.save(inventory));



		BookingRecord booking = new BookingRecord("BF101", "NYC","SFO","22-JAN-16",new Date(),"101");
		Set<Passenger> passengers = new HashSet<Passenger>();
		passengers.add(new Passenger("Gean","Franc","Male", booking));
		//	passengers.add(new Passenger("Redi","Ivan","Female",booking));

		booking.setPassengers(passengers);
		long record  = bookingService.book(booking);
		logger.info("Booking successfully saved..." + record);

		logger.info("Looking to load booking record...");
		logger.info("Result: " + bookingService.getBooking(record));


	}

}
