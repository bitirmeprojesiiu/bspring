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
    private int examId;
    //sınavın süresi
    private String duration;
    private String number;
    private String format;
    private Date examStartingDate;
    private Date examFinishingDate;

  @OneToMany(targetEntity=Question.class ,mappedBy = "examId", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Question> questions= new ArrayList<Question>();


    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
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
}
