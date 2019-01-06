package bitirme.service.imp;

import bitirme.model.*;

import java.text.ParseException;
import java.util.List;

public interface IExamService {


    List<Question> dLTExam(int examId) throws ParseException;

    List<Question> dLCExam(int examId) throws ParseException;

    int getUserIdWithExamId(int examId);

    State examDateValidation(int userId) throws ParseException;

    boolean addTestResult(TestResult testResult);

    boolean addClassicResult(ClassicResult classicResult);

    List<ClassicExam> getAllClassicExam();

    List<TestExam> getAllTestExam();
}
