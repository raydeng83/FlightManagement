package com.flightmanagement.domain;

/**
 * Created by z00382545 on 11/10/16.
 */
public class Fare {
    String flightNumber;
    String flightDate;
    String fare;

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return String.format("Fare [flightNumber=%s, flightDate=%s, fare=%s]", flightNumber, flightDate, fare);
    }
}
