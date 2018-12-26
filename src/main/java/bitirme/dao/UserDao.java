package bitirme.dao;

import bitirme.dao.imp.IUserDao;
import bitirme.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class UserDao implements IUserDao {

    @PersistenceContext
    private EntityManager entityManager;


    //buraya tekrar bak
    //isim ve soyisime göre tüm adaylar arasından arama yapma
    @Override
    public List<User> findAllByNameOrSurname(String name, String surname) {
        String query = "FROM user as usr WHERE usr.name=? OR usr.surname=?";

        List resultList =entityManager.createQuery(query).setParameter(1,name).setParameter(2,surname).getResultList();
        if(resultList.size()>0){
            return (List<User>) entityManager.createQuery(query).getResultList();
        }else{
            return null;
        }
    }

    //tüm adayları listeleme (ada göre sıralı)
    @Override
    public List<User> findAll() {
        String query ="FROM user as usr ORDER BY usr.name";
        return (List<User>) entityManager.createQuery(query).getResultList();
    }

    //aday ekleme
    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    //aday silme
    @Override
    public void delete(int userId) {
        entityManager.remove(getUserById(userId));
    }

    //id'ile adayı bulma
    @Override
    public User getUserById(int userId) {
        return entityManager.find(User.class, userId);
    }


}
