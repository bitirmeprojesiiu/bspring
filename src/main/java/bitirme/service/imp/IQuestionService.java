package bitirme.service.imp;

import bitirme.model.Question;

import java.util.List;

public interface IQuestionService {

    public List<Question> getAllClassicExamQuestions(int examId);

    public List<Question> getAllTestExamQuestions(int examId);
    //public boolean isExamValid(String examId);
}
