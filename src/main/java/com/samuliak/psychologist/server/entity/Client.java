package com.samuliak.psychologist.server.entity;

import javax.persistence.*;

//Клиент
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer ID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="questionnaire_id")
    private Questionnaire questionnaire;
    @Column(nullable = false)
    private String first_name;
    @Column(nullable = false)
    private String second_name;
    @Column(nullable = false)
    private String password;
    private int age;
    private String country;
    private String city;
    private String interest;

    public Client(){
    }

    public Client(Questionnaire questionnaire, String first_name, String second_name, String password, int age, String country, String city, String interest) {
        this.questionnaire = questionnaire;
        this.first_name = first_name;
        this.second_name = second_name;
        this.password = password;
        this.age = age;
        this.country = country;
        this.city = city;
        this.interest = interest;
    }
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }
}
