package com.samuliak.psychologist.server.entity;

import javax.persistence.*;

@Entity
@Table(name = "ex_clients")
public class ExClients {

    /*
    Здесь будут хранится прошлые клиенты врача
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer ID;

    @Column(nullable = false)
    private String doctor;

    @Column(nullable = false)
    private String client;

    public ExClients(){}

    public ExClients(String doctor, String client) {
        this.doctor = doctor;
        this.client = client;
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
}
