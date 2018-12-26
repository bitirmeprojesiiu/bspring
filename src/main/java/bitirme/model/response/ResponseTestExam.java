package bitirme.model.response;

import bitirme.model.TestExam;

import java.util.List;

public class ResponseTestExam {
    private String isSuccessful;
    private TestExam testExam;
    private List<TestExam> testExamList;
    private String errorMessage;
    private String successMessage;

    public ResponseTestExam(TestExam testExam) {
        setIsSuccessful("1");
        setTestExam(testExam);
    }
    public ResponseTestExam(List<TestExam> testExamList) {
        setIsSuccessful("1");
        setTestExamList(testExamList);
    }
    public ResponseTestExam(String message, String isSuccess) {
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

    public TestExam getTestExam() {
        return testExam;
    }

    public void setTestExam(TestExam testExam) {
        this.testExam = testExam;
    }

    public List<TestExam> getTestExamList() {
        return testExamList;
    }

    public void setTestExamList(List<TestExam> testExamList) {
        this.testExamList = testExamList;
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
