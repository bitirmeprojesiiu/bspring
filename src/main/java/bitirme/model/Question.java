package bitirme.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="question")
public class Question {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int questionId;

    @ManyToOne(targetEntity = TestExam.class)
    @JoinColumn(name = "exam_id")
    private int examId;

    private String quest;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;

    private String answer;

    public Question() {
    }

    public Question(String quest) {
        this.quest = quest;

        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.answer = answer;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getChoice2() {
        return choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuest() {
        return quest;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String answer1) {
        this.choice1 = choice1;
    }

    public String getAnswer2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice33() {
        return choice3;
    }

    public void setChoice33(String choice3) {
        this.choice3 = choice3;
    }

    public String getChoice4() {
        return choice4;
    }

    public void setChoice4(String choice4) {
        this.choice4 = choice4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    @Override
      public String toString(){
         return "Question{" +
            "question id=" + questionId +
            ", title='" + quest + '\'' +
            ", budget=" + choice1 +
            ", priority='" + choice2 + '\'' +
            ", deadline=" + choice3 +
            ", manager=" + choice4 +
            ", no. of employees=" + answer +
            '}';
    }
}
