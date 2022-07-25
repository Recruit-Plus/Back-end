package com.RecruitPlus.QuizPlatform.repository;
import com.RecruitPlus.QuizPlatform.model.Questions;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;

public interface QuestionRepository extends MongoRepository<Questions, String>
{

}
