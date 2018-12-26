package bitirme.model;

import javax.persistence.*;
import java.util.ArrayList;
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
    private String examStartingDate;
    private String examFinishingDate;

    @OneToMany(targetEntity=Question.class ,mappedBy = "examId", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Question> questions= new ArrayList<Question>();


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

    public String getExamStartingDate() {
        return examStartingDate;
    }

    public void setExamStartingDate(String examStartingDate) {
        this.examStartingDate = examStartingDate;
    }

    public String getExamFinishingDate() {
        return examFinishingDate;
    }

    public void setExamFinishingDate(String examFinishingDate) {
        this.examFinishingDate = examFinishingDate;
    }
}
