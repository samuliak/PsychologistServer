package com.samuliak.psychologist.server.entity;

import javax.persistence.*;

//Анкета, которую заполняет клиент
@Entity
@Table(name = "questionnaire")
public class Questionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer ID;

    private int clientid;

    /*
    Здесь будут разные поля, типа пол/вредные привычки и так дальше....
     */

    public Questionnaire(){
    }

    public Questionnaire(int clientid) {
        this.clientid = clientid;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }
}
