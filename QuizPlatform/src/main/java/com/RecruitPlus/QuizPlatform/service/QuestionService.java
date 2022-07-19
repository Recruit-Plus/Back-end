package com.RecruitPlus.QuizPlatform.service;

import com.RecruitPlus.QuizPlatform.model.Questions;
import com.RecruitPlus.QuizPlatform.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<Questions> getAllQuestions() {
        return questionRepository.findAll();
    }

    public void Update(Questions question)
    {
        questionRepository.save(question);
    }
    public void Insert(Questions question)
    {
        questionRepository.insert(question);
    }

}
