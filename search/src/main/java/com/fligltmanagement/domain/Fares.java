package com.fligltmanagement.domain;

import javax.persistence.*;

/**
 * Created by z00382545 on 11/10/16.
 */

@Entity
public class Fares {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "fare_id")
    long id;

    String fare;
    String currency;

    public Fares() {}


    public Fares(String fare,String currency) {
        super();
        this.fare = fare;
        this.currency = currency;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return String.format("Fares{id=%d, fare='%s', currency='%s'}", id, fare, currency);
    }
}
