package com.RecruitPlus.QuizPlatform.service;

import com.RecruitPlus.QuizPlatform.model.Question;
import com.RecruitPlus.QuizPlatform.model.Topic;
import com.RecruitPlus.QuizPlatform.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {

        return topicRepository.findAll();
    }

    public void saveTopic(Topic topic) {

        topicRepository.save(topic);
    }
}
