package com.flightmanagement.service;

import com.flightmanagement.domain.Fare;
import com.flightmanagement.repository.FaresRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by z00382545 on 11/10/16.
 */

@Service
public class FaresService {
    private static final Logger logger = LoggerFactory.getLogger(FaresService.class);

    @Autowired
    private FaresRepository faresRepository;

    public Fare getFare(String flightNumber, String flightDate) {
        logger.info("Looking for fares flightNumber "+ flightNumber + " flightDate "+ flightDate);
        return faresRepository.getFareByFlightNumberAndFlightDate(flightNumber, flightDate);
    }
}
