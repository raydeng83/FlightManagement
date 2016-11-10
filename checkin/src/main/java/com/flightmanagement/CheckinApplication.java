package com.flightmanagement;

import com.flightmanagement.domain.CheckinRecord;
import com.flightmanagement.repository.CheckinRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class CheckinApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(CheckinApplication.class);

	@Autowired
	CheckinRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CheckinApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		CheckinRecord record = new CheckinRecord("Franc", "Gean","28A",new Date(),"BF101","22-JAN-16",1);

		CheckinRecord result  = repository.save(record);
		logger.info("checked in successfully ..." + result);



		logger.info("Looking to load checkedIn record...");
		logger.info("Result: " + repository.findOne(result.getId()));


	}
}
