package bitirme.controller;


import bitirme.model.User;
import bitirme.model.response.ResponseUser;
import bitirme.service.imp.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class UserController implements Serializable {

    @Autowired
    IUserService userService;

    //tüm kullanıcıları listeleme-adayları
    @GetMapping("get_all_users")
    public ResponseEntity<List<User>> index() {

        try {
            List<User> list = userService.findAll();
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
