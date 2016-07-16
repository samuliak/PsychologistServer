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

    private String clientLogin;

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate = new Date();

    private String note;

    public Journal(){
    }

    public Journal(String clientLogin, Date creationDate, String note) {
        this.clientLogin = clientLogin;
        this.creationDate = creationDate;
        this.note = note;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getClient() {
        return clientLogin;
    }

    public void setClient(String client) {
        this.clientLogin = client;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
