package com.flightmanagement.repository;

import com.flightmanagement.domain.CheckinRecord;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by z00382545 on 11/10/16.
 */
public interface CheckinRepository extends CrudRepository<CheckinRecord, Long> {
}
