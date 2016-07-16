package com.samuliak.psychologist.server.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

//Клиент
@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer ID;

    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private String password;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="doctor")
    @Cascade(CascadeType.SAVE_UPDATE)
    private Psychologist doctor;

    private int age;
    private String country;
    private String city;
    private String interest;

    public Client(){
    }

    public Client(String login, String first_name, String second_name, String password, int age, String country, String city, String interest) {
        this.login = login;
        this.name = first_name;
        this.surname = second_name;
        this.password = password;
        this.age = age;
        this.country = country;
        this.city = city;
        this.interest = interest;
    }

    public Client(String first_name, String second_name, String password, int age, String country, String city, String interest) {
        this.name = first_name;
        this.surname = second_name;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public Psychologist getDoctor() {
        return doctor;
    }

    public void setDoctor(Psychologist doctor) {
        this.doctor = doctor;
    }
}
