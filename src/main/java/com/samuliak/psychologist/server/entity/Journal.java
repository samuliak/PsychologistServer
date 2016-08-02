package com.samuliak.psychologist.server.entity;

import javax.persistence.*;
import java.util.Date;

//Журнал (заметки), которые делает клиент
@Entity
@Table(name = "journal")
public class Journal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer ID;

    private String client;

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creation_date = new Date();

    private String note;

    public Journal(){
    }

    public Journal(String clientLogin, Date creationDate, String note) {
        this.client = clientLogin;
        this.creation_date = creationDate;
        this.note = note;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Date getCreationDate() {
        return creation_date;
    }

    public void setCreationDate(Date creationDate) {
        this.creation_date = creationDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
