package com.RecruitPlus.QuizPlatform.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigInteger;
import java.util.List;

@Document(collection = "questions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Questions {
    @Id
    private BigInteger id;
    @Field("question")
    private String question;
    @Field("choices")
    private List<String> choices;
    @Field("answer")
    private List<String> answer;
    @Field("type")
    private String type;
    @Field("category")
    private String category;
    @Field("sub_category")
    private List<String> sub_category;
    @Field("score")
    private int score;
    @Field("duration")
    private String duration;
    @Field("created_by")
    private String created_by;
    @Field("last_modified_by")
    private String last_modified_by;
    @Field("difficulty_level")
    private String difficulty_level;


}
