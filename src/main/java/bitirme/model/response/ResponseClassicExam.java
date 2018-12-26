package bitirme.model.response;

import bitirme.model.ClassicExam;

import java.util.List;

public class ResponseClassicExam {
    private String isSuccessful;
    private ClassicExam classicExam;
    private List<ClassicExam> classicExamList;
    private String errorMessage;
    private String successMessage;

    public ResponseClassicExam(ClassicExam classicExam) {
        setIsSuccessful("1");
        setClassicExam(classicExam);
    }
    public ResponseClassicExam(List<ClassicExam> classicExamList) {
        setIsSuccessful("1");
        setClassicExamList(classicExamList);
    }
    public ResponseClassicExam(String message, String isSuccess) {
        if(isSuccess.equals("1")){
            setSuccessMessage(message);
        }else{
            setErrorMessage(message);
        }
        setIsSuccessful(isSuccess);
    }

    public String getIsSuccessful() {
        return isSuccessful;
    }

    public void setIsSuccessful(String isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    public ClassicExam getClassicExam() {
        return classicExam;
    }

    public void setClassicExam(ClassicExam classicExam) {
        this.classicExam = classicExam;
    }

    public List<ClassicExam> getClassicExamList() {
        return classicExamList;
    }

    public void setClassicExamList(List<ClassicExam> classicExamList) {
        this.classicExamList = classicExamList;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getSuccessMessage() {
        return successMessage;
    }

    public void setSuccessMessage(String successMessage) {
        this.successMessage = successMessage;
    }
}
