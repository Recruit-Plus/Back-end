package com.RecruitPlus.QuizPlatform.controller;

import com.RecruitPlus.QuizPlatform.model.Question;
import com.RecruitPlus.QuizPlatform.model.Topic;
import com.RecruitPlus.QuizPlatform.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping("/v1")
    @ResponseBody
    public List<Topic> getAllTopics( ){
        List<Topic> topicList=topicService.getAllTopics();
        return topicList;
    }

    @PostMapping("/v1")
    @ResponseBody
    public ResponseEntity<Object> saveTopic(@RequestBody Topic topic)
    {
        topicService.saveTopic(topic);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
