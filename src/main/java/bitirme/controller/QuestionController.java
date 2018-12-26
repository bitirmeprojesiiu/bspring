package bitirme.controller;


import bitirme.model.Question;
import bitirme.model.State;
import bitirme.service.imp.IExamService;
import bitirme.service.imp.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
public class QuestionController implements Serializable {

    @Autowired
    IQuestionService questionService;

    @Autowired
    IExamService examService;

    //SINAV TARİHİ GEÇERLİYSE SINAV SORULARINI GETİRİYOR
    @GetMapping("get_all_questions")
    public ResponseEntity<Question> getQuestions(@RequestParam("examId") String examId) {

        List list = null;
        int examIdInt = Integer.valueOf(examId);

        try {

            String userId = examService.getUserIdWithExamId(examIdInt);
            State state = examService.examDateValidation(examIdInt);

            if (state.getState().equals("ready")) {
                list = (List<Question>) questionService.getAllQuesitons(examIdInt);
                return new ResponseEntity<Question>((Question) list, HttpStatus.OK);
            } else {
                return new ResponseEntity<Question>((Question) list, HttpStatus.OK);
            }

        } catch (Exception e) {
            return new ResponseEntity<Question>((Question) list, HttpStatus.NOT_FOUND);
        }
    }

//    @GetMapping("checkexam")
//    public ResponseEntity<State> checkExam(@RequestParam("password") String password, @RequestParam("userId") String userId) {
//
//        try {
//            return new ResponseEntity<State>(HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<State>(HttpStatus.NOT_FOUND);
//        }
//    }

}
