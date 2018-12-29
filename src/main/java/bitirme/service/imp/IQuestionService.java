package bitirme.service.imp;

import bitirme.model.Question;

import java.util.List;

public interface IQuestionService {

    public List<Question> getAllClassicExamQuesitons(int examId);

    public List<Question> getAllTestExamQuesitons(int examId);
    //public boolean isExamValid(String examId);
}
