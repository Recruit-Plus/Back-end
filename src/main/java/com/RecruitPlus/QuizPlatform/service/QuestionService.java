package com.RecruitPlus.QuizPlatform.service;

import com.RecruitPlus.QuizPlatform.model.Question;
import com.RecruitPlus.QuizPlatform.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    //Listing out all the questions
    public List<Question> getAllQuestions() {

        return questionRepository.findAll();
    }
    //Getting a question by specific id if exists
    public ResponseEntity<Object> getQuestionById(String questionId){

        Optional<Question> question= questionRepository.findById(questionId);
        if(question.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(question.get());
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    public void saveNewQuestion(Question question) {

        questionRepository.save(question);
    }
    public void deleteQuestion(String questionId) {

        questionRepository.deleteById(questionId);
    }
    //Getting list of questions which are filtered by topic,type and difficulty level
    public ResponseEntity<Object> byFilter(String[] topics,String type,String difficulty_level){
        Optional<Question> filteredQuestions=questionRepository.byFilter(topics,type,difficulty_level);
        if(filteredQuestions.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(filteredQuestions.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    //pagination
    public Page<Question> questionPaginated(Pageable p){
        return questionRepository.findAll( p);
    }

}
