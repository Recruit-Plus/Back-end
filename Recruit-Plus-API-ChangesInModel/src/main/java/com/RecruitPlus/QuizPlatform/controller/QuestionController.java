package com.RecruitPlus.QuizPlatform.controller;

import com.RecruitPlus.QuizPlatform.model.Questions;
import com.RecruitPlus.QuizPlatform.repository.QuestionRepository;
import com.RecruitPlus.QuizPlatform.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/questions/{questionId}")
    @ResponseBody
    public Optional<Questions> getQuestionById(@PathVariable  String questionId){

        Optional<Questions> questionsListById=questionService.getQuestionById(questionId);
        return questionsListById;
    }
    @PostMapping("/questions")
    public ResponseEntity<Object> saveQuestion(@RequestBody Questions question)
    {
        questionService.saveNewQuestion(question);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/questions")
    public ResponseEntity updateById(@RequestBody Questions question )
    {
        questionService.updateQuestion(question);
        return ResponseEntity.ok().build();
    }


    @DeleteMapping("/questions/{questionId}")
    public ResponseEntity<Object> deleteQuestion(@PathVariable String questionId){
        questionService.deleteQuestion(questionId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
