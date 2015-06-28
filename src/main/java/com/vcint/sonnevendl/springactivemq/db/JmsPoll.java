package com.vcint.sonnevendl.springactivemq.db;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by lorincsonnevend on 28/06/15.
 */
@Entity
@Table(name = "JMSPOLL")
public class JmsPoll {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "updatetype")
    private String updateType;

    @OneToOne
    @JoinColumn(name = "personid", referencedColumnName = "id")
    private Person person;

    @Column(name = "updatedate")
    private Timestamp updateDate;

    @Column(name = "timestamp")
    private Timestamp timestamp;

    public String getUpdateType() {
        return updateType;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
