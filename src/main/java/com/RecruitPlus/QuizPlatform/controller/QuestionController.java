package com.RecruitPlus.QuizPlatform.controller;

import com.RecruitPlus.QuizPlatform.model.Question;
import com.RecruitPlus.QuizPlatform.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/recruitPlus")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    //Listing out all the questions
    @GetMapping("/questions")
    @ResponseBody
    public  List<Question> getAllQuestions( ){
        List<Question> questionsList=questionService.getAllQuestions();
        return questionsList;
    }
    //Getting a question by specific id if exists
    @GetMapping("/questions/{questionId}")
    @ResponseBody
    public Optional<Question> getQuestionById(@PathVariable  String questionId){

        return questionService.getQuestionById(questionId);

    }
    @PostMapping("/questions")
    public ResponseEntity<Object> saveQuestion(@RequestBody Question question)
    {
        questionService.saveNewQuestion(question);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/question/{questionId}")
    public ResponseEntity<Object> deleteQuestion(@PathVariable String questionId){
        questionService.deleteQuestion(questionId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
    //Getting list of questions which are filtered by topic,type and difficulty level
    @GetMapping("filter/questions")
    public ResponseEntity<Object> getByFilters(@RequestParam String[] topics, @RequestParam(required = false) String type, @RequestParam(required = false) String difficulty_level)
    {
        return questionService.byFilters(topics,type,difficulty_level);
    }

    //pagination
    @GetMapping("/questionPages")
    public Page<Question> questionsPaginated(Pageable p){

        return questionService.questionPaginated(p);
    }

}
