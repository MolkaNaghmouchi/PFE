package com.pfe.elios.Controller;

import com.pfe.elios.entities.Quiz;
import com.pfe.elios.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class QuizController {



    @Autowired
 QuizService QuizService;




    // http://localhost:8081/SpringMVC/servlet/GetActivities
    @GetMapping("/GetQuiz")
    @ResponseBody
    public List<Quiz> getQuiz() {
        return QuizService.retrieveAllQuiz();

    }



    // http://localhost:8081/SpringMVC/servlet/retrieve-user/{user-id}
    @GetMapping("/retrieveQuiz/{user-id}")
    @ResponseBody
    public Quiz retrieveQuiz(@PathVariable("user-id") Long userId) {
        return QuizService.retrieveQuiz(userId);

    }

    // Ajouter User : http://localhost:8081/SpringMVC/servlet/AddActivity

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("auth/AddQuiz")
    @ResponseBody
    public String addFormation(@RequestBody Quiz u) {
        QuizService.addQuiz(u);

        return " Quiz ajouté";
    }




    // http://localhost:8081/SpringMVC/servlet/RemoveActivity/{user-id}
    @DeleteMapping("/RemoveQuiz/{user-id}")
    @ResponseBody
    public void removeQuiz(@PathVariable("user-id") Long userId) {
        QuizService.deleteQuiz(userId);
    }

    // http://localhost:8081/SpringMVC/servlet/ModifyActivity
    @PutMapping("/ModifyQuiz")
    @ResponseBody
    public Quiz modifyQuiz(@RequestBody Quiz Quiz) {
        return QuizService.updateQuiz(Quiz);

    }

    // http://localhost:8081/SpringMVC/servlet/retrieve-user/{user-id}
    @GetMapping("/FindQuizSortedByFormation")
    @ResponseBody
    public List<Quiz> 	  FindQuizSortedByFormation() {
        return QuizService.FindQuizSortedByName();

    }
}
