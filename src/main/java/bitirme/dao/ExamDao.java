package bitirme.dao;

import bitirme.dao.imp.IExamDao;
import bitirme.dao.imp.IQuestionDao;
import bitirme.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    public State examDateValidation(int userId) throws ParseException {

        //geri döneceği state objesini oluşturdum
        State state = new State();

        Date beginningDate = null;
        Date endingDate = null;

        //verilen userId'ye göre, users exam tablosundaki bilgileri bu userId için aldım
        //String query ="FROM UsersExam WHERE userId=:userId";
        //UsersExam usersExam = (UsersExam) entityManager.createQuery(query).getResultList()
        UsersExam usersExam = getUsersExamById(userId).get(0);

        //eğer kullanıcı için tanımlanmış bir sınav varsa buaraya girip tarihini kontrol edecek.
        if (examValidation(userId)) {

            //Sınavın ıdsini aldım.
            int eId = usersExam.getExamId();

            //state'i sorgulayıp sınavın test mi klasik mi olduğunu aldım
            String query1 = "FROM State as state WHERE state.examId = " + eId;
            List<State> stateList = (List<State>) entityManager.createQuery(query1).getResultList();

            state = stateList.get(0);

            if (state.getExamType().equals("test")) {

                //sınav testse testexam tabl'dan examıd bu olanın bilgilerini al
                String query2 = "FROM TestExam as testexam WHERE examId = " + eId;

                TestExam testExam = (TestExam) entityManager.createQuery(query2).getResultList().get(0);

                //geçerli sınavın başlangıç ve bitiş tarihlerini aldım.
                beginningDate = testExam.getExamStartingDate();
                endingDate = testExam.getExamFinishingDate();

            } else if (state.getExamType().equals("klasik")) {
                //eğer sınav test değil, klasikse buraya girip bu sprguyu kullanacak

                //sınav testse testexam tabl'dan examıd bu olanın bilgilerini al
                String query3 = "FROM ClassicExam as classicexam WHERE examId = " + eId;

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
        String query = "FROM UsersExam as ue WHERE ue.examId=" + examId;
        //SELECT exam.format
        String query2 = "FROM ClassicExam as ce WHERE ce.examId=" +examId;

        List<UsersExam> usersExams = (List<UsersExam>) entityManager.createQuery(query).getResultList();

        int usId = usersExams.get(0).getUserId();

        List <ClassicExam> classicExam = (List<ClassicExam>)entityManager.createQuery(query2).getResultList();

        String examFormat=classicExam.get(0).getFormat();


        State state = examDateValidation(usId);

        //sınav tipi kontrolü//klasikse alacak soruları
        if (examFormat.equals("classic")) {
            //sınav zamanı kontrolü
            if (state.getState().equals("ready")) {
               return questionDao.getAllClassicExamQuesitons(examId);
            } else
                return null;
        } else
            return null;
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
                return questionDao.getAllTestExamQuesitons(examId);
            } else
                return null;
        } else
            return null;
    }


}


/*


        String query = "FROM usersexam as ue WHERE ue.userId = ?";
        String query2 = "FROM exam WHERE examId = ?";
        String query3 = "FROM exam WHERE examId = ?";
        String query4 = "FROM state WHERE examId = ?";

        State state = new State();

        UsersExam usersExam = entityManager.find(UsersExam.class, userId);
        usersExam = (UsersExam) entityManager.createQuery(query).setParameter(1, userId).getResultList();
        List eId;
        String exId = (String) eId.get(0);

        if (exId != null && exId.isEmpty()) {

            List eType = entityManager.createQuery(query4).setParameter(1, eId).getResultList();
            String exType = (String) eType.get(0);

            if (exType != null && exType.isEmpty()) {
                List<String> firstDate = (List<String>) entityManager.createQuery(query2).setParameter(1, eId).getResultList();
                List<String> lastDate = (List<String>) entityManager.createQuery(query3).setParameter(1, eId).getResultList();

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
                Date fdateTime;
                Date ldateTime;
                Date now = new Date();
                simpleDateFormat.format(now);

                String fDate = firstDate.get(0);
                String lDate = lastDate.get(0);
                fdateTime = simpleDateFormat.parse(fDate);
                ldateTime = simpleDateFormat.parse(lDate);
                long diff = fdateTime.getTime() - now.getTime();
                //sınava 5 dj veya daha az varsa veya sınav zamanı gelmişse
                if (now.after(fdateTime) && now.before(ldateTime) || now.before(fdateTime) && diff <= 5) {
                    state.setState("ready");
                    return state;
                }
                //sınava 5 dk'dan fazla varsa
                if (now.before(fdateTime) && diff > 5) {
                    state.setState("not yet");
                    return state;
                } else
                    state.setState("passed");
                return state;

            } else
                state.setState("invalid");
            return state;

        } else
            state.setState("invalid");
 */