package bitirme.service.imp;

import bitirme.model.Question;

import java.util.List;

public interface IQuestionService {

    public List<Question> getAllQuesitons(int examId);
    //public boolean isExamValid(String examId);
}
