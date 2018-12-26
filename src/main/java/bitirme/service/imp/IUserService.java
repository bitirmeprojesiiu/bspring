package bitirme.service.imp;

import bitirme.model.User;

import java.util.List;

public interface IUserService {

    List<User> findAllByNameOrSurname(String name, String surname);

    List<User> findAll();

    void add(User user);

    void delete(int userId);

    User getUserById(int userId);

}
