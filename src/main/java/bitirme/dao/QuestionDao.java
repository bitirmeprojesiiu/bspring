package bitirme.dao;

import bitirme.dao.imp.IQuestionDao;
import bitirme.model.Question;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class QuestionDao implements IQuestionDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Question> getAllQuesitons(int examId) {

        String query = "SELECT que FROM Question as que , Exam as exam WHERE exam.examid = ?";
        List list = entityManager.createQuery(query).setParameter(1, examId).getResultList();
        return list;

    }

   /* @Override
    public boolean isExamValid(String examId){
        String query= "SELECT "
        return true;
    } */
}
