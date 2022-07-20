package com.RecruitPlus.QuizPlatform.service;


import com.RecruitPlus.QuizPlatform.model.Questions;
import com.RecruitPlus.QuizPlatform.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;

public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public void saveNewQuestion(Questions question)
    {
        questionRepository.save(question);
    }


}
