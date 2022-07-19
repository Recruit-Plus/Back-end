package com.RecruitPlus.QuizPlatform.controller;

import com.RecruitPlus.QuizPlatform.model.Questions;
import com.RecruitPlus.QuizPlatform.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;


    @GetMapping("/all")
    public  List<Questions> getAllQuestions( ){
        List<Questions> questionsList=questionService.getAllQuestions();
        return questionsList;
    }
    @PostMapping("/add-question")
    public String saveQuestion(@RequestBody Questions question){
        questionService.Insert(question);
        return "Question added successfully!";
    }
    @PutMapping
    public void update(@RequestBody Questions question )
    {
        this.questionService.Update(question);
    }


}
