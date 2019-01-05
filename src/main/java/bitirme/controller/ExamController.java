package bitirme.controller;


import bitirme.model.*;
import bitirme.service.imp.IExamService;
import bitirme.service.imp.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ExamController implements Serializable {

    @Autowired
    IExamService examService;

    @Autowired
    IUserService userService;

    @GetMapping("checkexam")
    public ResponseEntity<State> examCheck(@RequestParam("userId") int userId, @RequestParam("userPassword") String userPassword) {


        int userIdInt = userId;
        State state = null;
        ResponseEntity r = new ResponseEntity<>(state, HttpStatus.OK);

        try {
            User user = userService.getUserById(userIdInt);
            String password = user.getUserPassword();

            if (userPassword.equals(password)) {

                state = examService.examDateValidation(userIdInt);
                if (state.getState().equals("ready")) {
                    r = new ResponseEntity<>(state, HttpStatus.OK);
                } else if (state.getState().equals("not yet")) {
                    r = new ResponseEntity<>(state, HttpStatus.OK);
                } else if (state.getState().equals("passed")) {
                    r = new ResponseEntity<>(state, HttpStatus.OK);
                }
            } else
                r = new ResponseEntity<>(state, HttpStatus.OK);

        } catch (Exception e) {
            r = new ResponseEntity<State>(HttpStatus.NOT_FOUND);
        }
        return r;
    }

    @PostMapping("downloadclassicexam")
    public ResponseEntity<ArrayList<Question>> dLCExam(@RequestParam("examId") String examId) {

        ArrayList<Question> questions = null;
        int examIdInt = Integer.valueOf(examId);
        try {
            questions = (ArrayList<Question>) examService.dLCExam(examIdInt);
            return new ResponseEntity<>(questions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(questions, HttpStatus.NOT_FOUND);
        }
    }

    //    @GetMapping("get_admins")
//    public ResponseEntity<List<Admin>> getAllAdmins() throws EntityNotFoundException {
//        List<Admin> list = adminService.getAdminList();
//        return new ResponseEntity(new ResponseAdmin(list), HttpStatus.OK);
//    }
    @PostMapping("downloadtestexam")
    public ResponseEntity<ArrayList<Question>> dLTExam(@RequestParam("examId") String examId) {

        int examIdInt = Integer.valueOf(examId);
        try {
            ArrayList<Question> questions = (ArrayList<Question>) examService.dLTExam(examIdInt);
            return new ResponseEntity<>(questions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("testresult")
    public ResponseEntity<ResultResponse> testResult (@RequestBody TestResult testResult) throws EntityNotFoundException {
        boolean flag= examService.addTestResult(testResult);
        ResultResponse response= new ResultResponse();
        if (!flag){
            response.setResponse("FAIL");
        //   return new  ResponseEntity(response, HttpStatus.OK);
        }
        else {
            response.setResponse("OK");
          //  return new ResponseEntity(response, HttpStatus.OK);
        }

        return new ResponseEntity(response, HttpStatus.OK);
    }


    @PostMapping("classicresult")
    public ResponseEntity<ResultResponse> classicResult (@RequestBody ClassicResult classicResult) throws EntityNotFoundException {
        boolean flag= examService.addClassicResult(classicResult);

        ResultResponse response= new ResultResponse();
        if (!flag){
            response.setResponse("FAIL");
           // return new  ResponseEntity(response, HttpStatus.OK);
        }
        else {
            response.setResponse("OK");
           // return new ResponseEntity(response, HttpStatus.OK);
        }

        return new  ResponseEntity(response, HttpStatus.OK);
    }

}
