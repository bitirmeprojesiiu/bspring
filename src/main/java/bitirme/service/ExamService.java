package bitirme.service;

import bitirme.dao.imp.IExamDao;
import bitirme.model.*;
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
    public int getUserIdWithExamId (int examId){
        return examDao.getUserIdWithExamId(examId);
    }

    @Override
    public synchronized boolean addTestResult(TestResult testResult) {
        if (examDao.testResultExists(testResult.getTestResultId())) {
            return false;
        } else {
            examDao.addTestExamResult(testResult);
            return true;
        }
    }



    @Override
    public synchronized boolean addClassicResult(ClassicResult classicResult) {
        if (examDao.classicResultExists(classicResult.getClassicResultId())) {
            return false;
        } else {
            examDao.addClassicExamResult(classicResult);
            return true;
        }
    }


    @Override
    public List<ClassicExam> getAllClassicExam (){
       return examDao.getAllClassicExam();
    }

    @Override
    public List<TestExam> getAllTestExam (){
        return examDao.getAllTestExam();
    }
}
