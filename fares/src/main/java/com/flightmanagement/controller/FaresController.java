package com.flightmanagement.controller;

import com.flightmanagement.domain.Fare;
import com.flightmanagement.service.FaresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by z00382545 on 11/10/16.
 */
@CrossOrigin
@RestController
@RequestMapping("/fares")
public class FaresController {

    @Autowired
    private FaresService faresService;

    @RequestMapping("/get")
    Fare getFare(@RequestParam (value="flightNumber") String flightNumber, @RequestParam(value="flightDate") String flightDate) {
        return faresService.getFare(flightNumber,flightDate);
    }
}
