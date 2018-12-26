package bitirme.service.imp;

import bitirme.model.Question;
import bitirme.model.State;

import java.text.ParseException;
import java.util.List;

public interface IExamService {


    List<Question> dLTExam(int examId) throws ParseException;

    List<Question> dLCExam(int examId) throws ParseException;

    String getUserIdWithExamId(int examId);

    State examDateValidation(int userId) throws ParseException;
}
