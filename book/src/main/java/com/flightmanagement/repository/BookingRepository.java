package com.flightmanagement.repository;

import com.flightmanagement.domain.BookingRecord;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by z00382545 on 11/10/16.
 */
public interface BookingRepository extends CrudRepository<BookingRecord, Long>{
}
