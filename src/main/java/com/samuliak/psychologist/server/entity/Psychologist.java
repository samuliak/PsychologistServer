package com.samuliak.psychologist.server.entity;

import javax.persistence.*;

//Психолог
@Entity
@Table(name = "psychologist")
public class Psychologist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer ID;
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
    private String place_of_work;
    private String university;
    private String specialization;
    private String competence;
    private String direction_of_work;

    public Psychologist() {
    }

    public Psychologist(String first_name, String second_name, String password, int age, String country,
                        String city, String interest, String place_of_work, String university, String specialization,
                        String competence, String direction_of_work) {
        this.first_name = first_name;
        this.second_name = second_name;
        this.password = password;
        this.age = age;
        this.country = country;
        this.city = city;
        this.interest = interest;
        this.place_of_work = place_of_work;
        this.university = university;
        this.specialization = specialization;
        this.competence = competence;
        this.direction_of_work = direction_of_work;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
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

    public String getPlace_of_work() {
        return place_of_work;
    }

    public void setPlace_of_work(String place_of_work) {
        this.place_of_work = place_of_work;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public String getDirection_of_work() {
        return direction_of_work;
    }

    public void setDirection_of_work(String direction_of_work) {
        this.direction_of_work = direction_of_work;
    }
}