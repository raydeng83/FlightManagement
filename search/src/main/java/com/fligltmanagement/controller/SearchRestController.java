package com.fligltmanagement.controller;

import com.fligltmanagement.domain.Flight;
import com.fligltmanagement.domain.SearchQuery;
import com.fligltmanagement.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by z00382545 on 11/10/16.
 */
@CrossOrigin
@RestController
@RequestMapping("/search")
@RefreshScope
public class SearchRestController {

    private static final Logger logger = LoggerFactory.getLogger(SearchService.class);


    private SearchService searchService;

    @Value("${originairports.shutdown}")
    private String originAirportShutdownList;

    @Autowired
    public SearchRestController(SearchService searchComponent) {
        this.searchService = searchComponent;
    }

    @RequestMapping(value="/get", method = RequestMethod.POST)
    List<Flight> search(@RequestBody SearchQuery query){
        logger.info("Input : "+ query);
        if(Arrays.asList(originAirportShutdownList.split(",")).contains(query.getOrigin())){
            logger.info("The origin airport is in shutdown state");
            return new ArrayList<Flight>();
        }
        return searchService.search(query);
    }
}
