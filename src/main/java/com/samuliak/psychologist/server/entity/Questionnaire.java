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

    @OneToOne(mappedBy = "questionnaire")
    private Client client;

    /*
    Здесь будут разные поля, типа пол/вредные привычки и так дальше....
     */

    public Questionnaire(){
    }

}
