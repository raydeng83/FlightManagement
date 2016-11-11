package com.fligltmanagement.controller;

import com.fligltmanagement.domain.Flight;
import com.fligltmanagement.domain.SearchQuery;
import com.fligltmanagement.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by z00382545 on 11/10/16.
 */
@CrossOrigin
@RestController
@RequestMapping("/search")
public class SearchRestController {

    private SearchService searchService;

    @Autowired
    public SearchRestController(SearchService searchComponent) {
        this.searchService = searchComponent;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    List<Flight> search(@RequestBody SearchQuery query) {
        System.out.println("Input : " + query);
        return searchService.search(query);
    }
}
