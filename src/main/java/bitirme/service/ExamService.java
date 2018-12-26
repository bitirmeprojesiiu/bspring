package bitirme.service;

import bitirme.dao.imp.IExamDao;
import bitirme.model.Question;
import bitirme.model.State;
import bitirme.service.imp.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class ExamService implements IExamService {

    @Autowired
    IExamDao examDao;

    @Override
    public State examDateValidation(int userId) throws ParseException {
        return examDao.examDateValidation(userId);
    }

    @Override
    public List<Question> dLTExam(int examId) throws ParseException{
        return examDao.dLTExam(examId);
    }

    @Override
    public List<Question> dLCExam(int examId) throws ParseException{
        return examDao.dLCExam(examId);
    }

    @Override
    public String getUserIdWithExamId (int examId){
        return examDao.getUserIdWithExamId(examId);
    }

}
