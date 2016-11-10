package com.flightmanagement.repository;

import com.flightmanagement.domain.Fare;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by z00382545 on 11/10/16.
 */
public interface FaresRepository extends CrudRepository<Fare, Long> {
    Fare getFareByFlightNumberAndFlightDate(String flightNumber, String flightDate);
}
