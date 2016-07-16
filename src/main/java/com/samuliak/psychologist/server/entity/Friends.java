package com.samuliak.psychologist.server.entity;

import javax.persistence.*;

//Связь между психологами (становление друзьями)
@Entity
@Table(name = "friends")
public class Friends {

    /*
    Дружба между докторами. Доктор_один - тот кто посылает запрос на дружбу,
    а доктор_два - с кем хотят подружиться. Если мы ещём с кем дружит доктор,
    тогда нужно сверять обои значение, так как могут подружится с ним.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer ID;

    private String doctor_login_one;
    private String doctor_login_two;
    private boolean isFriend;

    public Friends(){}

    public Friends(String doctor_login_one, String doctor_login_two) {
        this.doctor_login_one = doctor_login_one;
        this.doctor_login_two = doctor_login_two;
        this.isFriend = false;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getDoctor_login_one() {
        return doctor_login_one;
    }

    public void setDoctor_login_one(String doctor_login_one) {
        this.doctor_login_one = doctor_login_one;
    }

    public String getDoctor_login_two() {
        return doctor_login_two;
    }

    public void setDoctor_login_two(String doctor_login_two) {
        this.doctor_login_two = doctor_login_two;
    }

    public boolean isFriend() {
        return isFriend;
    }

    public void setFriend(boolean friend) {
        isFriend = friend;
    }
}
