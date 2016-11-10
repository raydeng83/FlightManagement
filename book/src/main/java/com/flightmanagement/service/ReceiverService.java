package com.flightmanagement.service;

import com.flightmanagement.util.BookingStatus;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by z00382545 on 11/10/16.
 */

@Service
public class ReceiverService {

    @Autowired
    private BookingService bookingService;

    @RabbitListener(queues = "CheckINQ")
    public void processMessage(long bookingId) {
        System.out.println(bookingId);
        bookingService.updateStatus(BookingStatus.CHECKED_IN, bookingId);
    }
}
