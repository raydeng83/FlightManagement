package com.flightmanagement.controller;

import com.flightmanagement.domain.BookingRecord;
import com.flightmanagement.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by z00382545 on 11/10/16.
 */

@CrossOrigin
@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @RequestMapping(value="/create", method = RequestMethod.POST)
    long book(@RequestBody BookingRecord record) {
        System.out.println("Booking request "+record);
        return bookingService.book(record);
    }

    @RequestMapping("/get/{id}")
    BookingRecord getBooking(@PathVariable long id) {
        return bookingService.getBooking(id);
    }
}
