package bitirme.dao.imp;

import bitirme.model.Question;

import java.util.List;

public interface IQuestionDao {

    List getAllTestExamQuestions(int examId);

    List getAllClassicExamQuestions(int examId);
}
