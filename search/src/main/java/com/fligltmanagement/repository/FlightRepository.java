package com.fligltmanagement.repository;

import com.fligltmanagement.domain.Flight;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by z00382545 on 11/10/16.
 */
public interface FlightRepository extends CrudRepository<Flight, Long> {
    List<Flight> findByOriginAndDestinationAndFlightDate(String origin, String destination, String flightDate);

    Flight findByFlightNumberAndFlightDate(String flightNumber, String flightDate);
}
