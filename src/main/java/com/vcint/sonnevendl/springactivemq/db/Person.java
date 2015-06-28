package com.vcint.sonnevendl.springactivemq.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;


/**
 * Created by lorincsonnevend on 28/06/15.
 */
@Entity
class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Person [firstName=" + this.firstName + ", lastName=" + this.lastName
                + "]";
    }
}
