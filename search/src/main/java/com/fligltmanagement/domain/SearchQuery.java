package com.fligltmanagement.domain;

/**
 * Created by z00382545 on 11/10/16.
 */
public class SearchQuery {

    String origin;
    String destination;
    String flightDate;

    public SearchQuery() {}

    public SearchQuery(String origin, String destination, String flightDate) {
        this.origin = origin;
        this.destination = destination;
        this.flightDate = flightDate;
    }

    @Override
    public String toString() {
        return String.format("SearchQuery{origin='%s', destination='%s', flightDate='%s'}", origin, destination, flightDate);
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }
}
