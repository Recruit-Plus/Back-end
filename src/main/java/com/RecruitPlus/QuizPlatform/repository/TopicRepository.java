package com.RecruitPlus.QuizPlatform.repository;

import com.RecruitPlus.QuizPlatform.model.Topic;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TopicRepository extends MongoRepository<Topic,String> {
}
