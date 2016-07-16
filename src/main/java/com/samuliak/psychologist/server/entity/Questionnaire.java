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

    private String ask1;
    private String ask2;
    private int ask3;
    private int ask4;
    private String ask5;
    private String ask6;
    private String ask7_1;
    private String ask7_2;
    private String ask8;
    private String ask9;
    private String ask10;
    private String ask11_1;
    private String ask11_2;
    private String ask12;
    private String ask13;
    private String ask14;
    private String ask15;
    private String ask16;
    private String ask17;
    private String ask18;
    private String ask19;
    private String ask20;

    public Questionnaire(){
    }

    public Questionnaire(int clientid, String ask1, String ask2, int ask3,
                         int ask4, String ask5, String ask6,
                         String ask7_1, String ask7_2,
                         String ask8, String ask9, String ask10,
                         String ask11_1, String ask11_2,
                         String ask12, String ask13, String ask14,
                         String ask15, String ask16, String ask17,
                         String ask18, String ask19, String ask20) {
        this.clientid = clientid;
        this.ask1 = ask1;
        this.ask2 = ask2;
        this.ask3 = ask3;
        this.ask4 = ask4;
        this.ask5 = ask5;
        this.ask6 = ask6;
        this.ask7_1 = ask7_1;
        this.ask7_2 = ask7_2;
        this.ask8 = ask8;
        this.ask9 = ask9;
        this.ask10 = ask10;
        this.ask11_1 = ask11_1;
        this.ask11_2 = ask11_2;
        this.ask12 = ask12;
        this.ask13 = ask13;
        this.ask14 = ask14;
        this.ask15 = ask15;
        this.ask16 = ask16;
        this.ask17 = ask17;
        this.ask18 = ask18;
        this.ask19 = ask19;
        this.ask20 = ask20;
    }

    public String getAsk1() {
        return ask1;
    }

    public void setAsk1(String ask1) {
        this.ask1 = ask1;
    }

    public String getAsk2() {
        return ask2;
    }

    public void setAsk2(String ask2) {
        this.ask2 = ask2;
    }

    public int getAsk3() {
        return ask3;
    }

    public void setAsk3(int ask3) {
        this.ask3 = ask3;
    }

    public int getAsk4() {
        return ask4;
    }

    public void setAsk4(int ask4) {
        this.ask4 = ask4;
    }

    public String getAsk5() {
        return ask5;
    }

    public void setAsk5(String ask5) {
        this.ask5 = ask5;
    }

    public String getAsk6() {
        return ask6;
    }

    public void setAsk6(String ask6) {
        this.ask6 = ask6;
    }

    public String getAsk7_1() {
        return ask7_1;
    }

    public void setAsk7_1(String ask7_1) {
        this.ask7_1 = ask7_1;
    }

    public String getAsk7_2() {
        return ask7_2;
    }

    public void setAsk7_2(String ask7_2) {
        this.ask7_2 = ask7_2;
    }

    public String getAsk8() {
        return ask8;
    }

    public void setAsk8(String ask8) {
        this.ask8 = ask8;
    }

    public String getAsk9() {
        return ask9;
    }

    public void setAsk9(String ask9) {
        this.ask9 = ask9;
    }

    public String getAsk10() {
        return ask10;
    }

    public void setAsk10(String ask10) {
        this.ask10 = ask10;
    }

    public String getAsk11_1() {
        return ask11_1;
    }

    public void setAsk11_1(String ask11_1) {
        this.ask11_1 = ask11_1;
    }

    public String getAsk11_2() {
        return ask11_2;
    }

    public void setAsk11_2(String ask11_2) {
        this.ask11_2 = ask11_2;
    }

    public String getAsk12() {
        return ask12;
    }

    public void setAsk12(String ask12) {
        this.ask12 = ask12;
    }

    public String getAsk13() {
        return ask13;
    }

    public void setAsk13(String ask13) {
        this.ask13 = ask13;
    }

    public String getAsk14() {
        return ask14;
    }

    public void setAsk14(String ask14) {
        this.ask14 = ask14;
    }

    public String getAsk15() {
        return ask15;
    }

    public void setAsk15(String ask15) {
        this.ask15 = ask15;
    }

    public String getAsk16() {
        return ask16;
    }

    public void setAsk16(String ask16) {
        this.ask16 = ask16;
    }

    public String getAsk17() {
        return ask17;
    }

    public void setAsk17(String ask17) {
        this.ask17 = ask17;
    }

    public String getAsk18() {
        return ask18;
    }

    public void setAsk18(String ask18) {
        this.ask18 = ask18;
    }

    public String getAsk19() {
        return ask19;
    }

    public void setAsk19(String ask19) {
        this.ask19 = ask19;
    }

    public String getAsk20() {
        return ask20;
    }

    public void setAsk20(String ask20) {
        this.ask20 = ask20;
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
