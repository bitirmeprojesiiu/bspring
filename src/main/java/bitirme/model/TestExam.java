package bitirme.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="testexam")
public class TestExam implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int examId;

    //sınavın süresi
    private String duration;
    private String number;
    private String format;
    private Date examStartingDate;
    private Date examFinishingDate;


    public TestExam() {
    }


    public TestExam(String duration, String number, String format, Date examStartingDate, Date examFinishingDate) {
        this.duration = duration;
        this.number = number;
        this.format = format;
        this.examStartingDate = examStartingDate;
        this.examFinishingDate = examFinishingDate;
    }

    public int getExamId() {
        return examId;
    }


    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public Date getExamStartingDate() {
        return examStartingDate;
    }

    public void setExamStartingDate(Date examStartingDate) {
        this.examStartingDate = examStartingDate;
    }

    public Date getExamFinishingDate() {
        return examFinishingDate;
    }

    public void setExamFinishingDate(Date examFinishingDate) {
        this.examFinishingDate = examFinishingDate;
    }


    @Override
    public String toString(){
        return "TestExam{" +
                "examId=" + examId +
                ", starting date for exam='" + examStartingDate + '\'' +
                ", last day for exam=" + examFinishingDate +
                ", duration=" + duration +
                '}';
    }
}


