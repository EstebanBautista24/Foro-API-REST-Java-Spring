package com.esteban.forohub.model.DTO;

import com.esteban.forohub.model.Topic;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TopicDetails {
    private Long id;
    private String title;
    private String message;
    private LocalDateTime publishDate;
    private String usernameAutor;
    private String courseName;
    private List<ResponseDetails> responseDetails;
    public TopicDetails(Topic topic) {
        this.id= topic.getIdTopic();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.publishDate = topic.getPublishDate();
        this.usernameAutor = topic.getAuthor().getName();
        this.courseName = topic.getCourse().getName();
        if(topic.getResponses() == null){
            this.responseDetails = null;
        }else{
            responseDetails = topic.getResponses().stream().map(r-> new ResponseDetails(r)).toList();
        }

    }
}
