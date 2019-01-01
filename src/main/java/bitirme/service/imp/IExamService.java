package bitirme.service.imp;

import bitirme.model.ClassicResult;
import bitirme.model.Question;
import bitirme.model.State;
import bitirme.model.TestResult;

import java.text.ParseException;
import java.util.List;

public interface IExamService {


    List<Question> dLTExam(int examId) throws ParseException;

    List<Question> dLCExam(int examId) throws ParseException;

    int getUserIdWithExamId(int examId);

    State examDateValidation(int userId) throws ParseException;

    boolean addTestResult(TestResult testResult);

    boolean addClassicResult(ClassicResult classicResult);
}
