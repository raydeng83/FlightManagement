package com.flightmanagement.controller;

import com.flightmanagement.domain.CheckinRecord;
import com.flightmanagement.service.CheckinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/checkin")
public class CheckInController {

	@Autowired
	private CheckinService checkinService;
	
	@RequestMapping("/get/{id}")
	CheckinRecord getCheckIn(@PathVariable long id ){
		return checkinService.getCheckInRecord(id);
	}

	@RequestMapping(value ="/create", method = RequestMethod.POST)
	long checkIn(@RequestBody CheckinRecord checkIn){
		return checkinService.checkIn(checkIn);
	}
	
}
