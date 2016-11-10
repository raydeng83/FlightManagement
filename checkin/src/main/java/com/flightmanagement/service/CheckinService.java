package com.flightmanagement.service;

import com.flightmanagement.domain.CheckinRecord;
import com.flightmanagement.repository.CheckinRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by z00382545 on 11/10/16.
 */

@Service
public class CheckinService {
    private static final Logger logger = LoggerFactory.getLogger(CheckinService.class);

    @Autowired
    private CheckinRepository checkinRepository;

    @Autowired
    private SenderService senderService;

    public long checkIn(CheckinRecord checkIn) {
        checkIn.setCheckInTime(new Date());
        logger.info("Saving checkin ");
        //save
        long id = checkinRepository.save(checkIn).getId();
        logger.info("Successfully saved checkin ");
        //send a message back to booking to update status
        logger.info("Sending booking id "+ id);
        senderService.send(id);
        return id;

    }

    public CheckinRecord getCheckInRecord(long id){
        return checkinRepository.findOne(id);
    }

}
