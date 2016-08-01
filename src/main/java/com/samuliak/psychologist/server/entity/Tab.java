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

    private String full_name_doctor;
    private String full_name_client;

    public Tab(){}

    public Tab(String doctor, String client, String full1, String full2) {
        this.doctor = doctor;
        this.client = client;
        this.full_name_doctor = full1;
        this.full_name_client = full2;
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

    public String getFull_name_doctor() {
        return full_name_doctor;
    }

    public void setFull_name_doctor(String full_name_doctor) {
        this.full_name_doctor = full_name_doctor;
    }

    public String getFull_name_client() {
        return full_name_client;
    }

    public void setFull_name_client(String full_name_client) {
        this.full_name_client = full_name_client;
    }
}
