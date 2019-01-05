package bitirme.model;

import javax.persistence.*;

@Entity
@Table(name="usersexam")
public class UsersExam {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int usersExamId;

//    @ManyToMany(targetEntity=User.class ,mappedBy = "userId", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private int userId;

  //  @ManyToMany(targetEntity=TestExam.class ,mappedBy = "userId", fetch=FetchType.LAZY, cascade = CascadeType.ALL)
    private int examId;
    private String userPassword;

    private int classicExamId;

    private String examType;


    public int getClassicExamId() {
        return classicExamId;
    }

    public void setClassicExamId(int classicExamId) {
        this.classicExamId = classicExamId;
    }

    public int getUsersExamId() {
        return usersExamId;
    }

    public void setUsersExamId(int usersExamId) {
        this.usersExamId = usersExamId;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public UsersExam() {
    }

    public UsersExam(int userId, int examId) {
        this.userId = userId;
        this.examId = examId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }
}
