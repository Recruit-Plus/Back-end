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

import java.math.BigInteger;
import java.util.List;


@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("/questions")
    public ResponseEntity<Object> saveQuestion(@RequestBody Questions question)
    {
        questionService.saveNewQuestion(question);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
