package com.RecruitPlus.QuizPlatform.service;


import com.RecruitPlus.QuizPlatform.model.Question;
import com.RecruitPlus.QuizPlatform.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() {

        return questionRepository.findAll();
    }

    public Optional<Question> getQuestionById(String questionId){

        return questionRepository.findById(questionId);
    }

    public Question saveNewQuestion(Question question)
    {
        return questionRepository.save(question);
    }

    public void deleteQuestion(String id) {

        questionRepository.deleteById(id);
    }

    public void deleteAllQuestion() {

        questionRepository.deleteAll();
    }



}
