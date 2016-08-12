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
    @Column(nullable = false, unique = true)
    private String login;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private String password;
    private int experience;
    private String sex;
    private String birthday;
    private String country;
    private String city;
    private String prof_interest;
    private String place_of_work;
    private String university;
    private String specialization;
    private String competence;
    private String direction_of_work;
    private boolean online;

    public Psychologist() {
    }

    public Psychologist(String login, String name, String surname, String password,
                        int experience, String sex, String birthday, String country,
                        String city, String prof_interest, String place_of_work,
                        String university, String specialization, String competence,
                        String direction_of_work) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.experience = experience;
        this.sex = sex;
        this.birthday = birthday;
        this.country = country;
        this.city = city;
        this.prof_interest = prof_interest;
        this.place_of_work = place_of_work;
        this.university = university;
        this.specialization = specialization;
        this.competence = competence;
        this.direction_of_work = direction_of_work;
        this.online = false;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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

    public String getProf_interest() {
        return prof_interest;
    }

    public void setProf_interest(String prof_interest) {
        this.prof_interest = prof_interest;
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

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
}