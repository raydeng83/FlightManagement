package com.fligltmanagement.domain;

import javax.persistence.*;

/**
 * Created by z00382545 on 11/10/16.
 */

@Entity
public class Flight {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long id;

    String flightNumber;
    String origin;
    String destination;
    String flightDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fare_Id")
    Fares fares;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="inv_Id")
    Inventory inventory;

    public Flight () {}

    public Flight(String flightNumber, String origin, String destination, String flightDate, Fares fares, Inventory inventory) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.flightDate = flightDate;
        this.fares = fares;
        this.inventory = inventory;
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

    public Fares getFares() {
        return fares;
    }

    public void setFares(Fares fares) {
        this.fares = fares;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return String.format("Flight{id=%d, flightNumber='%s', origin='%s', destination='%s', flightDate='%s', fares=%s, inventory=%s}", id, flightNumber, origin, destination, flightDate, fares, inventory);
    }
}
