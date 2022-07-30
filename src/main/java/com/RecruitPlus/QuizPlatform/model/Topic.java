package com.RecruitPlus.QuizPlatform.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection="topics")
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
    @Id
    private String topic_id;
    @Field("topic")
    private String topic;
}
