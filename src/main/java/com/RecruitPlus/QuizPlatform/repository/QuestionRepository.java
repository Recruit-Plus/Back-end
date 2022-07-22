package com.RecruitPlus.QuizPlatform.repository;
import com.RecruitPlus.QuizPlatform.model.Questions;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface QuestionRepository extends MongoRepository<Questions, String>
{
    @Query("{ 'type' : ?0 }")
    public List<Questions> byType(String type);

    @Query("{ 'topics' : ?0}")
    public List<Questions> byTopics(String[] topics);

    @Query("{ 'difficulty_level' : ?0 }")
    public List<Questions> byDiffLevel(String difficulty_level);
}
