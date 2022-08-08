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


import javax.lang.model.util.Elements;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/questions/v1")
@CrossOrigin(origins ="*")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    //Listing out all the questions
    @GetMapping("/")
    public  Page<Question> getAllQuestions(Pageable p ){

        return questionService.questionPaginated(p);
    }

    @GetMapping("/questions")
    public  List<Question> getAllQuestions( ){

        return questionService.allQuestion();
    }

    //Getting a question by specific id if exists
    @GetMapping("/question/{question_id}")
    public Optional<Question> getQuestionById(@PathVariable(value="question_id")  String questionId){

        return questionService.getQuestionById(questionId);

    }
    //adding a new question
    @PostMapping("/question")
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
    @PutMapping("/question/{question_id}")
    public void updateById(@RequestBody Question question,@PathVariable(value="question_id") String questionId )
    {
        questionService.updateQuestion(questionId,question);
    }

    //deleting a question with specific id
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/question/{question_id}")
    public void deleteQuestion(@PathVariable(value="question_id") String questionId){
         questionService.deleteQuestion(questionId);
    }

    //deleting all questions
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/")
    public boolean deleteAllQuestion(){
        questionService.deleteAllQuestion();
        return true;
    }

    //Getting list of questions which are filtered by topic,type and difficulty level
    @GetMapping("/search")
    public List<Question> filterQuestions(@RequestParam(required = false) String[] topics, @RequestParam(required = false) String type, @RequestParam(required = false) String difficulty_level)
    {
        return questionService.findQuestionByFilters(topics,type,difficulty_level);
    }



}
