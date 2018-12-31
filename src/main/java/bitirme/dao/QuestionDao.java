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

        String query = "FROM ClassicExam as cexam WHERE cexam.examId = " +examId;
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
        List<Question> classicQuestionsList = null;

        String examType;

        String query = "FROM TestExam as texam WHERE texam.examId = "+examId;
        List <TestExam> testExamList = entityManager.createQuery(query).getResultList();

        int numberOfQuestions = Integer.parseInt(testExamList.get(0).getNumber());

        for (int i=0; i<(testExamList.size()); i++){
            testQuestionsList=testExamList.get(i).getQuestions();
        }
        return testQuestionsList;
    }




    /*
        int numberOfQuestions = Integer.parseInt(testExamList.get(0).getNumber());

        for (int i=0; i<(testExamList.size()); i++){
            testQuestionsList=testExamList.get(i).getQuestions();
        }
        return testQuestionsList;




         String questionText = allQuestionsList.get(i).getQuest();
                String questionChoice1 = allQuestionsList.get(i).getChoice1();
                String questionChoice2 = allQuestionsList.get(i).getChoice2();
                String questionChoice3 = allQuestionsList.get(i).getChoice3();
                String questionChoice4 = allQuestionsList.get(i).getChoice4();
                 String answer = allQuestionsList.get(i).getAnswer();
                  Question testQuestion = new Question(questionText, questionChoice1,questionChoice2,questionChoice3,questionChoice4,answer);



                    String query2 = "FROM Question AS question WHERE question.examId =" +examId;
        List <Question> allQuestionsList = entityManager.createQuery(query2).getResultList();

        for (int i=0; i<(allQuestionsList.size()); i++){
            examType = allQuestionsList.get(i).getExamFormat();

            if (examType.equals("klasik")){
                String questionText = allQuestionsList.get(i).getQuest();
                Question classicQuestion = new Question(questionText);

                classicQuestionsList.add(classicQuestion);
                return classicQuestionsList;
            }

           else if (examType.equals("test")){

               Question testQuestion = new Question();

               testQuestion.setQuest(allQuestionsList.get(i).getQuest());

                testQuestion.setChoice1(allQuestionsList.get(i).getChoice1());
                testQuestion.setChoice2(allQuestionsList.get(i).getChoice2());
                testQuestion.setChoice3(allQuestionsList.get(i).getChoice3());
                testQuestion.setChoice4(allQuestionsList.get(i).getChoice4());


                testQuestion.setAnswer(allQuestionsList.get(i).getAnswer());

                testQuestionsList.add(testQuestion);
                return testQuestionsList;
            }
        }


 return null;
 */
}
