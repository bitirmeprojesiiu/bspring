package bitirme.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="state")
public class State {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int stateId;
    //valid mi --- valid,invalid
    private String state;

//    @Id
//    private String examId;
    //test,classic
    @NotNull
    private String examType;
    private String time;
    //yyyy/MM/dd HH:mm


    public State() {
    }

    public State(String state, String examId, String examType, String time) {
        this.state = state;

//      !! kontrol et !!
//        this.examId = examId;
        this.examType = examType;
        this.time = time;
    }

    public State(State state) {

    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

//    !! kontrol et !!
//    public String getExamId() {
//        return examId;
//    }
//
//    public void setExamId(String examId) {
//        this.examId = examId;
//    }


    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
