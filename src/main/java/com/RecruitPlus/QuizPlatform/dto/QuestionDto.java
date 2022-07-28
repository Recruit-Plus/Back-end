package com.RecruitPlus.QuizPlatform.dto;

import lombok.Data;


import java.util.List;

@Data
public class QuestionDto
{
        private String questionId;
        private String question;
        private List<String> choices;

}
