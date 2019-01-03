package bitirme.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ResultResponse {

    @Id
    private int resultResponseId;
   private String response;

    public String getResponse() {
        return response;
    }

    public int getResultResponseId() {
        return resultResponseId;
    }

    public void setResultResponseId(int resultResponseId) {
        this.resultResponseId = resultResponseId;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public ResultResponse() {
    }
}
