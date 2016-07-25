package com.samuliak.psychologist.server.entity;

import javax.persistence.*;

@Entity
@Table(name = "current_clients")
public class CurrentClients {

    /*
    Здесь будут хранится теперешнии клиенты врача
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer ID;

    private String doctor;

    @Column(nullable = false, unique = true)
    private String client;

    private boolean isClient;

    public CurrentClients(){}

    public CurrentClients(String doctor, String client) {
        this.doctor = doctor;
        this.client = client;
        isClient = false;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public boolean isClient() {
        return isClient;
    }

    public void setClient(boolean client) {
        isClient = client;
    }
}
