package com.RecruitPlus.QuizPlatform.Dto;

import lombok.Data;

import java.util.List;

@Data
public class QuestionDto
    {
        private String question_id;
        private String question;
        private List<String> choices;

    }

