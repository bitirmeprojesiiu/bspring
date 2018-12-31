package bitirme.dao;

import bitirme.dao.imp.IQuestionDao;
import bitirme.model.ClassicExam;
import bitirme.model.Question;
import bitirme.model.TestExam;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class QuestionDao implements IQuestionDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Question> getAllTestExamQuestions(int examId) {

        ArrayList<Question> testQuestionsList = new ArrayList<>();
        List<Question> classicQuestionsList = null;


        TestExam testExam = new TestExam();
        Question question;
        String examType = "test";

        String query = "FROM TestExam as texam WHERE texam.examId = " + examId;
        List<TestExam> testExamList = entityManager.createQuery(query).getResultList();

        String query1 = "FROM Question as question WHERE question.examId = " + examId;
        List<Question> allQuestionsList = entityManager.createQuery(query1).getResultList();

        int numberOfQuestions = Integer.parseInt(testExamList.get(0).getNumber());


        for (int i = 0; i < (allQuestionsList.size()); i++) {
            examType = allQuestionsList.get(i).getExamFormat();

if (examType.equals("test")){
    Question testQuestion = new Question();


    testQuestion.setExamFormat("test");

    testQuestion.setQuest(allQuestionsList.get(i).getQuest());

    testQuestion.setChoice1(allQuestionsList.get(i).getChoice1());
    testQuestion.setChoice2(allQuestionsList.get(i).getChoice2());
    testQuestion.setChoice3(allQuestionsList.get(i).getChoice3());
    testQuestion.setChoice4(allQuestionsList.get(i).getChoice4());


    testQuestion.setAnswer(allQuestionsList.get(i).getAnswer());

    testQuestionsList.add( testQuestion);
}

        }

        return testQuestionsList;
    }

    @Override
    public List<Question> getAllClassicExamQuestions(int examId) {

        ArrayList<Question> classicQuestionsList = new ArrayList<>();


        ClassicExam classicExam = new ClassicExam();
        Question question;
        String examType = "test";

        String query = "FROM ClassicExam as texam WHERE texam.examId = " + examId;
        List<ClassicExam> classicExamList = entityManager.createQuery(query).getResultList();

        String query1 = "FROM Question as question WHERE question.examId = " + examId;
        List<Question> allQuestionsList = entityManager.createQuery(query1).getResultList();

        int numberOfQuestions = Integer.parseInt(classicExamList.get(0).getNumber());


        for (int i = 0; i < (allQuestionsList.size()); i++) {
            examType = allQuestionsList.get(i).getExamFormat();

if (examType.equals("klasik")){
    Question classicQuestion = new Question();


    classicQuestion.setExamFormat("klasik");

    classicQuestion.setQuest(allQuestionsList.get(i).getQuest());


    classicQuestionsList.add( classicQuestion);
}

        }

        return classicQuestionsList;
    }

}


