package com.RecruitPlus.QuizPlatform.controller;

import com.RecruitPlus.QuizPlatform.model.Questions;
import com.RecruitPlus.QuizPlatform.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/recruitPlus")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/questions")
    @ResponseBody
    public  List<Questions> getAllQuestions( ){
        List<Questions> questionsList=questionService.getAllQuestions();
        return questionsList;
    }

    @GetMapping("/questions/{id}")
    @ResponseBody
    public Optional<Questions> getQuestionById(@PathVariable  String id){

        Optional<Questions> questionsListById=questionService.getQuestionById(id);
        return questionsListById;
    }


    @DeleteMapping("/question/{id}")
    public ResponseEntity<Object> deleteQuestion(@PathVariable String id){
        questionService.deleteQuestion(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
