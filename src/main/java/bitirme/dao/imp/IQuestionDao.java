package bitirme.dao.imp;

import java.util.List;

public interface IQuestionDao {

    List getAllClassicExamQuesitons(int examId);
    List getAllTestExamQuesitons(int examId);

}
