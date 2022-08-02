package com.RecruitPlus.QuizPlatform.service;


import com.RecruitPlus.QuizPlatform.model.Questions;
import com.RecruitPlus.QuizPlatform.repository.QuestionRepository;
import org.jetbrains.annotations.NotNull;
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

    public void updateQuestion( Questions question)
    {
        Questions findbyId= questionRepository.findById(question.getQuestionId())
        .orElseThrow(() -> new RuntimeException(String.format("Cannot find question by Id",question.getQuestionId())));

        findbyId.setQuestion(question.getQuestion());
        findbyId.setChoices(question.getChoices());
        findbyId.setAnswer(question.getAnswer());
        findbyId.setType(question.getType());
        findbyId.setTopics(question.getTopics());
        findbyId.setScore(question.getScore());
        findbyId.setDuration(question.getDuration());
        findbyId.setCreated_by(question.getCreated_by());
        findbyId.setLast_modified_by(question.getLast_modified_by());
        findbyId.setDifficulty_level(question.getDifficulty_level());
        questionRepository.save(findbyId);

        }

    public void saveNewQuestion(Questions question) {
        questionRepository.save(question);
    }

    public void deleteQuestion(String questionId) {

        questionRepository.deleteById(questionId);
    }



}
