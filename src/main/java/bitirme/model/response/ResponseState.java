package bitirme.model.response;

import bitirme.model.State;

import java.util.List;

public class ResponseState {
    private String isSuccessful;
    private State state;
    private List<State> stateList;
    private String errorMessage;
    private String successMessage;

    public ResponseState(State state) {
        setIsSuccessful("1");
        setState(state);
    }
    public ResponseState(List<State> stateList) {
        setIsSuccessful("1");
        setStateList(stateList);
    }
    public ResponseState(String message, String isSuccess) {
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

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<State> getStateList() {
        return stateList;
    }

    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
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
