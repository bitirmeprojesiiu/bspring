package bitirme.model;

import javax.persistence.*;

@Entity
@Table(name="classicresult")
public class ClassicResult {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int classicResultId;
    private int userId;
    private int classicExamId;
    private String name,surname,phonenumber,email,cheatControl;
    private String answer;

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

    public int getUserId() {
        return userId;
    }

    public int getClassicResultId() {
        return classicResultId;
    }

    public void setClassicResultId(int classicResultId) {
        this.classicResultId = classicResultId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCheatControl() {
        return cheatControl;
    }

    public void setCheatControl(String cheatControl) {
        this.cheatControl = cheatControl;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
