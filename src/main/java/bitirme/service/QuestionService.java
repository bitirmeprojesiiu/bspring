package bitirme.service;

import bitirme.dao.imp.IQuestionDao;
import bitirme.model.Question;
import bitirme.service.imp.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements IQuestionService {

    @Autowired
    IQuestionDao questionDao;

    @Override
    public List<Question> getAllClassicExamQuesitons(int examId) {
        return questionDao.getAllClassicExamQuesitons(examId);
    }

    @Override
    public List<Question> getAllTestExamQuesitons(int examId) {
        return questionDao.getAllTestExamQuesitons(examId);
    }
  /*  @Override
    public boolean isExamValid(String examId) {
        return questionDao.isExamValid(examId);
    } */

}
