package com.RecruitPlus.QuizPlatform.repository;
import com.RecruitPlus.QuizPlatform.model.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface QuestionRepository extends MongoRepository<Question, String>
{

}
