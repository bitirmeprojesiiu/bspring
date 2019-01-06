package bitirme.dao;

import bitirme.dao.imp.IExamDao;
import bitirme.dao.imp.IQuestionDao;
import bitirme.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Transactional
@Repository
public class ExamDao implements IExamDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    IQuestionDao questionDao;


    @Override
    public List<UsersExam> getUsersExamById(int userId) {
        String query = "FROM UsersExam as usersexam WHERE usersexam.userId=" + userId;
        return (List<UsersExam>) entityManager.createQuery(query).getResultList();

    }


    //bu user için tanımlı sınav var mı?
    @Override
    public boolean examValidation(int userId) {

        // verilen userId için users exam tablosundaki bilgileri aldım ve usersexam'e attım, examid'sini examId'ye attım
        //  UsersExam usersExam = (UsersExam) getUsersExamById(userId);

        List<UsersExam> usersExamList = getUsersExamById(userId);

        UsersExam usersExam = usersExamList.get(0);

        //kullanıcı için sınav tanımlanmamışsa veya sınavın türü belli değilse false dönüyor.
        return usersExam.getExamType() != null;
    }

    //exam'in  tarihinin geçerli olup olmadığını kontrol et
    @Override
    public State examDateValidation(int userId) {

        int eId;
        //geri döneceği state objesini oluşturdum
        State state = new State();

        Date beginningDate = null;
        Date endingDate = null;

        //verilen userId'ye göre, users exam tablosundaki bilgileri bu userId için aldım

        UsersExam usersExam = getUsersExamById(userId).get(0);
        if (usersExam.getExamType().equals("test")){
           eId= usersExam.getExamId();
            String query1 = "FROM State as state WHERE state.examId = " + eId;
            List<State> stateList = (List<State>) entityManager.createQuery(query1).getResultList();

            state = stateList.get(0);
        }

        else {
           eId= usersExam.getClassicExamId();

            String query9 = "FROM State as state WHERE state.classicExamId = " + eId;
            List<State> stateList = (List<State>) entityManager.createQuery(query9).getResultList();

            state =stateList.get(0);
        }
        //eğer kullanıcı için tanımlanmış bir sınav varsa buaraya girip tarihini kontrol edecek.
        if (examValidation(userId)) {

            //Sınavın ıdsini aldım.

            //state'i sorgulayıp sınavın test mi klasik mi olduğunu aldım


            if (state.getExamType().equals("test")) {

                //sınav testse testexam tabl'dan examıd bu olanın bilgilerini al
                String query2 = "FROM TestExam as testexam WHERE examId = " + eId;

                TestExam testExam = (TestExam) entityManager.createQuery(query2).getResultList().get(0);

                //geçerli sınavın başlangıç ve bitiş tarihlerini aldım.
                beginningDate = testExam.getExamStartingDate();
                endingDate = testExam.getExamFinishingDate();

            } if (state.getExamType().equals("klasik")) {
                //eğer sınav test değil, klasikse buraya girip bu sprguyu kullanacak

                //sınav testse testexam tabl'dan examıd bu olanın bilgilerini al
                String query3 = "FROM ClassicExam as classicexam WHERE classicexam.classicExamId = " + eId;

                ClassicExam classicExam = (ClassicExam) entityManager.createQuery(query3).getResultList().get(0);

                //geçerli sınavın başlangıç ve bitiş tarihlerini aldım.
                beginningDate = classicExam.getExamStartingDate();
                endingDate = classicExam.getExamFinishingDate();

            }
            // bu date formatına göre bugünün tarihini aldım
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
            Date currentDate = new Date();
            simpleDateFormat.format(currentDate);

            //datelerin formatını düzenledim ve sınavın son tarihine ne kadar kaldığını hesapladım.
            long diff = beginningDate.getTime() - currentDate.getTime();

            //kalan zamanı gün saat dakika ve saniye cinsine çevirme
            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            //sınava 5 dj veya daha az varsa veya sınav zamanı gelmişse
            if ((currentDate.after(beginningDate) && currentDate.before(endingDate)) || ((diff <= 1000*60*5)) && (diff>0)){

                    state.setState("ready");
                    return state;

            }else if(currentDate.after(endingDate)){ //sınavın süresi geçmişse passed
                state.setState("passed");
                return state;
            }
            else if (diff > 1000*60*5) { //sınava 5 dk'dan fazla varsa

                state.setState("not yet");
                return state;

            }


        }
        //eğer geçerli sınav yoksa invalid dönüyor
        else {
            state.setState("invalid");
        }

        return state;
    }

    @Override
    public int getUserIdWithExamId(int examId) {

        String query = "FROM UsersExam as ue WHERE ue.examId=" +examId;
        List<UsersExam> usersExams = (List<UsersExam>) entityManager.createQuery(query).getResultList();

        if (usersExams.size() > 0) {
            int userId  = usersExams.get(0).getUserId();
          //  String userId = (String) usersExams.get(0).getUserId();
            return userId;
        } else
            return 0;
    }


    @Override
    public List<Question> dLCExam(int examId) throws ParseException {

        //SELECT usersExam.userId
        String query = "FROM UsersExam as ue WHERE ue.classicExamId=" + examId;
        //SELECT exam.format
        String query2 = "FROM ClassicExam as ce WHERE ce.classicExamId=" + examId;

        List<UsersExam> usersExams = (List<UsersExam>) entityManager.createQuery(query).getResultList();

        int usId = usersExams.get(0).getUserId();

        List<ClassicExam> classicExam = (List<ClassicExam>) entityManager.createQuery(query2).getResultList();

        String examFormat = classicExam.get(0).getFormat();


        State state = examDateValidation(usId);

        //sınav tipi kontrolü//klasikse alacak soruları
        if (examFormat.equals("klasik")) {
            //sınav zamanı kontrolü
            if (state.getState().equals("ready")) {
                return questionDao.getAllClassicExamQuestions(examId);
                //return questionDao.getAllClassicExamQuestions(examId);
            } else
                return null;
        } else {
            return null;
        }
    }

    @Override
    public List<Question> dLTExam(int examId) throws ParseException {

        //SELECT usersExam.userId
        String query = "FROM UsersExam as ue WHERE ue.examId=" +examId;
        //SELECT exam.format
        String query2 = "FROM TestExam as texam WHERE texam.examId=" +examId;

        List<UsersExam> usersExams = (List<UsersExam>) entityManager.createQuery(query).getResultList();

        int usId = usersExams.get(0).getUserId();

        List <TestExam> classicExam = (List<TestExam>)entityManager.createQuery(query2).getResultList();

        String examFormat=classicExam.get(0).getFormat();
        State state = examDateValidation(usId);


        //sınav tipi kontrolü//klasikse alacak soruları
        if (examFormat.equals("test")) {
            //sınav zamanı kontrolü
            if (state.getState().equals("ready")) {
                return questionDao.getAllTestExamQuestions(examId);
            } else
                return null;
        } else
            return null;
    }

    @Override
    public void addTestExamResult (TestResult testResult){
        entityManager.persist(testResult);
    }

    @Override
    public void addClassicExamResult (ClassicResult classicResult){
        entityManager.persist(classicResult);
    }


    @Override
    public boolean classicResultExists(int classicResultId) {
        String hql = "FROM ClassicResult as crs WHERE crs.classicResultId = " +classicResultId;
        int count = entityManager.createQuery(hql).getResultList().size();
        return count > 0;
    }


    @Override
    public boolean testResultExists(int testResultId) {
        String hql = "FROM TestResult as trs WHERE trs.testResultId = " +testResultId;
        int count = entityManager.createQuery(hql).getResultList().size();
        return count > 0;
    }


    @Override
    public List<ClassicExam> getAllClassicExam(){

        String query ="FROM ClassicExam ";
        return (List<ClassicExam>) entityManager.createQuery(query).getResultList();

    }

    @Override
    public List<TestExam> getAllTestExam(){

        String query ="FROM TestExam ";
        return (List<TestExam>) entityManager.createQuery(query).getResultList();

    }
}

