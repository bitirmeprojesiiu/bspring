package bitirme.dao;

import bitirme.dao.imp.IQuestionDao;
import bitirme.model.ClassicExam;
import bitirme.model.Question;
import bitirme.model.TestExam;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class QuestionDao implements IQuestionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Question> getAllClassicExamQuesitons(int examId) {

        List<Question> classicQuestionsList = null;

        String query = "FROM ClassicExam as cexam WHERE cexam.examid = ?" +examId;
        List <ClassicExam> classicExamList = entityManager.createQuery(query).getResultList();
        int numberOfQuestions = Integer.parseInt(classicExamList.get(0).getNumber());

        for (int i=0; i<=numberOfQuestions; i++){
          classicQuestionsList= classicExamList.get(i).getQuestions();
        }
        return classicQuestionsList;

    }

    @Override
    public List<Question> getAllTestExamQuesitons(int examId) {

        List<Question> testQuestionsList = null;


        String query = "FROM TextExam as texam WHERE texam.examid = ?"+examId;
        List <TestExam> testExamList = entityManager.createQuery(query).getResultList();

        int numberOfQuestions = Integer.parseInt(testExamList.get(0).getNumber());

        for (int i=0; i<=numberOfQuestions; i++){
            testQuestionsList= testExamList.get(i).getQuestions();
        }
        return testQuestionsList;


    }

}
