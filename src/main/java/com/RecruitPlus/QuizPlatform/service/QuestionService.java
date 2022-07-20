package com.RecruitPlus.QuizPlatform.service;


import com.RecruitPlus.QuizPlatform.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;

public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;


    public void deleteQuestion(BigInteger id) {
        questionRepository.deleteById(id);
    }



}
