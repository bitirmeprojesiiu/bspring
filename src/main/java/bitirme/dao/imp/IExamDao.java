package bitirme.dao.imp;

import bitirme.model.Question;
import bitirme.model.State;
import bitirme.model.UsersExam;

import java.text.ParseException;
import java.util.List;


public interface IExamDao {

    List<UsersExam> getUsersExamById(int userId);

    boolean examValidation(int userId);

    State examDateValidation(int userId) throws ParseException;

    List<Question> dLCExam(int examId) throws ParseException;

    List<Question> dLTExam(int examId) throws ParseException;

    int getUserIdWithExamId(int examId);
}
