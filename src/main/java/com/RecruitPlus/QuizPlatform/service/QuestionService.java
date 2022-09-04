package com.RecruitPlus.QuizPlatform.service;

import com.RecruitPlus.QuizPlatform.Exceptions.QuestionNotFoundException;
import com.RecruitPlus.QuizPlatform.model.Question;
import com.RecruitPlus.QuizPlatform.repository.QuestionRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    MongoTemplate mongoTemplate;
    //Listing out all the questions and pagination
    public Page<Question> questionPaginated(Pageable p){

        return questionRepository.findAll( p);
    }

    //Getting a question by specific id if exists
    public Optional<Question> getQuestionById(String questionId){

        Optional<Question> question= questionRepository.findById(questionId);
        if(question.isPresent()) {
            return question;
        }
        else
            throw new QuestionNotFoundException(questionId);
    }
    // adding a new question
    public Question saveNewQuestion(Question question)
    {
        return questionRepository.save(question);
    }
    //updating existing question
    public void updateQuestion(String questionId,Question question)

    {
        Question findById= questionRepository.findById(questionId)
                .orElseThrow(() -> new QuestionNotFoundException(questionId));

        findById.setQuestion(question.getQuestion());
        findById.setChoices(question.getChoices());
        findById.setAnswer(question.getAnswer());
        findById.setType(question.getType());
        findById.setTopics(question.getTopics());
        findById.setScore(question.getScore());
        findById.setDuration(question.getDuration());
        findById.setCreated_by(question.getCreated_by());
        findById.setLast_modified_by(question.getLast_modified_by());
        findById.setDifficulty_level(question.getDifficulty_level());
        questionRepository.save(findById);

    }
    //deleting a question with specific id
    public void deleteQuestion(String id) {
        Optional<Question> question= questionRepository.findById(id);
        if(question.isPresent()) {
            questionRepository.deleteById(id);
        }
        else
            throw new QuestionNotFoundException(id);
    }
    //deleting all questions
    public void deleteAllQuestion() {

        questionRepository.deleteAll();
    }
    //Getting list of questions which are filtered by topic,type and difficulty level
    public List<Question> findQuestionByFilters(String[] topics, String type, String difficulty_level){
        Query query = new Query();
        List<Criteria> criteria = new ArrayList<>();
        if (topics != null)
            criteria.add(Criteria.where("topics").is(topics));
        if (type != null && !type.isEmpty())
            criteria.add(Criteria.where("Type").is(type));
        if (difficulty_level != null && !difficulty_level.isEmpty())
            criteria.add(Criteria.where("difficulty_level").in(difficulty_level));

        if (!criteria.isEmpty())
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
        return mongoTemplate.find(query,Question.class);

    }
    public List<Question> allQuestion(){

        return questionRepository.findAll();
    }

    public List<Optional<Question>> findByMultipleId(List question_ids){
        List<Optional<Question>> questions=new ArrayList<Optional<Question>>();
        int n=question_ids.size();
        for(int i=0;i<n;i++){
            questions.add(questionRepository.findById((question_ids.get(i)).toString()
                    .replace("[","").replace("]","")));
        }
        return questions;
    }



}
