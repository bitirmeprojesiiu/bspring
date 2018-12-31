package bitirme.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="classicexam")
public class ClassicExam {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int classicExamId;
    //sınavın süresi
    private String duration;
    private String number;
    private String format;
    private Date examStartingDate;
    private Date examFinishingDate;


    public int getClassicExamId() {
        return classicExamId;
    }

    public void setClassicExamId(int classicExamId) {
        this.classicExamId = classicExamId;
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
}
