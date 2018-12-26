package bitirme.model.response;

import bitirme.model.Question;

import java.util.List;

public class ResponseQuestion {
    private String isSuccessful;
    private Question question;
    private List<Question> questionList;
    private String errorMessage;
    private String successMessage;

    public ResponseQuestion(Question question) {
        setIsSuccessful("1");
        setQuestion(question);
    }
    public ResponseQuestion(List<Question> questionList) {
        setIsSuccessful("1");
        setQuestionList(questionList);
    }
    public ResponseQuestion(String message, String isSuccess) {
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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> adminList) {
        this.questionList = questionList;
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
