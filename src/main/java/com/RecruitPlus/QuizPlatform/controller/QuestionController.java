package com.RecruitPlus.QuizPlatform.controller;

import com.RecruitPlus.QuizPlatform.Dto.QuestionDto;
import com.RecruitPlus.QuizPlatform.model.Question;
import com.RecruitPlus.QuizPlatform.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    //Listing out all the questions
    @GetMapping("/v1")
    public  List<Question> getAllQuestions( ){
        List<Question> questionsList=questionService.getAllQuestions();
        return questionsList;
    }

    //Getting a question by specific id if exists
    @GetMapping("/v1/question/{question_id}")
    public Optional<Question> getQuestionById(@PathVariable  String question_id){

        return questionService.getQuestionById(question_id);

    }
    //adding a new question
    @PostMapping("/v1")
    @ResponseStatus(code = HttpStatus.CREATED)
    public QuestionDto saveQuestion(@RequestBody Question question)
    {

        Question savedQuestion  = questionService.saveNewQuestion(question);
        QuestionDto questionDto = new QuestionDto();
        BeanUtils.copyProperties(savedQuestion,questionDto);

        return questionDto;

    }

    //updating existing question
    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping("/v1/question/{question_id}")
    public Optional<Question> updateById(@PathVariable String question_id,@RequestBody Question question )
    {
        return questionService.updateQuestion(question_id,question);
    }

    //deleting a question with specific id
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/v1/question/{question_id}")
    public void deleteQuestion(@PathVariable String question_id){
         questionService.deleteQuestion(question_id);
    }

    //deleting all questions
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/v1")
    public boolean deleteAllQuestion(){
        questionService.deleteAllQuestion();
        return true;
    }

    //Getting list of questions which are filtered by topic,type and difficulty level
    @GetMapping("/v1/question")
    public List<Question> getByFilters(@RequestParam(required = false) String[] topics, @RequestParam(required = false) String type, @RequestParam(required = false) String difficulty_level)
    {
        return questionService.findQuestionByFilters(topics,type,difficulty_level);
    }

    //pagination
    @GetMapping
    public Page<Question> questionsPaginated(Pageable p){
        return questionService.questionPaginated(p);
    }

}
