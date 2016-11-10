package com.fligltmanagement.domain;

import javax.persistence.*;

/**
 * Created by z00382545 on 11/10/16.
 */

@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "inv_id")
    long id;

    int count;


    public Inventory() {
        super();
    }

    public Inventory(int count) {
        super();
        this.count = count;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return String.format("Inventory{id=%d, count=%d}", id, count);
    }
}
