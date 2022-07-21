package com.RecruitPlus.QuizPlatform.service;


import com.RecruitPlus.QuizPlatform.model.Questions;
import com.RecruitPlus.QuizPlatform.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<Questions> getAllQuestions() {

        return questionRepository.findAll();
    }

    public Optional<Questions> getQuestionById(String questionId){

        return questionRepository.findById(questionId);
    }

    public void saveNewQuestion(Questions question) {
        questionRepository.save(question);
    }
    public void deleteQuestion(String questionId) {

        questionRepository.deleteById(questionId);
    }



}
