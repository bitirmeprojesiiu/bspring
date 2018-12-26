package bitirme.model;

import javax.persistence.*;

@Entity
@Table(name="testresult")
public class TestResult {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int testResultId;

    private String tc;
    private String name,surname,phonenumber,email, trueanswer, falseanswer,cheatControl;

    public int getTestResultId() {
        return testResultId;
    }

    public void setTestResultId(int testResultId) {
        this.testResultId = testResultId;
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

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getTrueanswer() {
        return trueanswer;
    }

    public void setTrueanswer(String trueanswer) {
        this.trueanswer = trueanswer;
    }

    public String getFalseanswer() {
        return falseanswer;
    }

    public void setFalseanswer(String falseanswer) {
        this.falseanswer = falseanswer;
    }

    public String getCheatControl() {
        return cheatControl;
    }

    public void setCheatControl(String cheatControl) {
        this.cheatControl = cheatControl;
    }
}
