package com.flightmanagement.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by z00382545 on 11/10/16.
 */

@Entity
public class Fare {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long id;

    String flightNumber;
    String flightDate;
    String fare;


    public Fare() {
        super();
    }


    public Fare(String flightNumber, String flightDate, String fare) {
        super();
        this.flightNumber = flightNumber;
        this.flightDate = flightDate;
        this.fare = fare;
    }


    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }


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
        return String.format("Fares [id=%d, flightNumber=%s, flightDate=%s, fare=%s]", id, flightNumber, flightDate, fare);
    }

}
