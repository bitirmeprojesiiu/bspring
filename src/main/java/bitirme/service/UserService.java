package bitirme.service;

import bitirme.dao.imp.IUserDao;
import bitirme.model.User;
import bitirme.service.imp.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public List<User> findAllByNameOrSurname(String name, String surname){
        return userDao.findAllByNameOrSurname(name,surname);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void delete(int userId) {
         userDao.delete(userId);
    }

    @Override
    public User getUserById(int userId) {
        User user = userDao.getUserById(userId);
        return user;
    }

}
