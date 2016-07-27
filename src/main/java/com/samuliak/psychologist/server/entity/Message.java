package com.samuliak.psychologist.server.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer ID;

    private String text;

    @Column(name = "creation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creation_date = new Date();

    private String sender;

    @Column(nullable = false)
    private int tab_id;

    public Message(){}

    public Message(String text, Date creation_date, int tab_id, String sender) {
        this.text = text;
        this.creation_date = creation_date;
        this.tab_id = tab_id;
        this.sender = sender;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public int getTab_id() {
        return tab_id;
    }

    public void setTab_id(int tab_id) {
        this.tab_id = tab_id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
