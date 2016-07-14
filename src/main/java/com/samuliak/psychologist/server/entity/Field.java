package com.samuliak.psychologist.server.entity;

import javax.persistence.*;

//Поле, которое характеризирует психолога
@Entity
@Table(name = "field")
public class Field {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer ID;

    @ManyToOne
    @JoinColumn(name = "psyh_id", nullable = false)
    private Psychologist psyh;

    @Column(nullable = false)
    private String field_ask;
    @Column(nullable = false)
    private String field_answer;

    public Field(){
    }

    public Field(Psychologist psyh, String field_ask, String field_answer) {
        this.psyh = psyh;
        this.field_ask = field_ask;
        this.field_answer = field_answer;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Psychologist getPsyh() {
        return psyh;
    }

    public void setPsyh(Psychologist psyh) {
        this.psyh = psyh;
    }

    public String getField_ask() {
        return field_ask;
    }

    public void setField_ask(String field_ask) {
        this.field_ask = field_ask;
    }

    public String getField_answer() {
        return field_answer;
    }

    public void setField_answer(String field_answer) {
        this.field_answer = field_answer;
    }
}
