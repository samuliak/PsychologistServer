package com.samuliak.psychologist.server.entity;

import javax.persistence.*;

@Entity
@Table(name = "tab")
public class Tab {
    /*
    Здесь будут хранится табы, кто с кем переписывается
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer ID;

    private String doctor;

    private String client;

    public Tab(){}

    public Tab(String doctor, String client) {
        this.doctor = doctor;
        this.client = client;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
}
