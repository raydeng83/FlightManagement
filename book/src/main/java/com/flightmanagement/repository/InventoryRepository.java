package com.flightmanagement.repository;

import com.flightmanagement.domain.Inventory;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by z00382545 on 11/10/16.
 */
public interface InventoryRepository extends CrudRepository<Inventory, Long> {
    Inventory findByFlightNumberAndFlightDate(String flightNumber, String flightDate);
}
