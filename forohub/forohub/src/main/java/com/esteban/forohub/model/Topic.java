package com.esteban.forohub.model;

import com.esteban.forohub.model.DTO.RegisterTopic;
import com.esteban.forohub.model.DTO.UpdateTopic;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTopic;
    private String title;
    private String message;
    private LocalDateTime publishDate;
    private boolean status;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "idUser")
    private User author;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "idCourse")
    private Course course;
    @OneToMany(mappedBy = "topic")
    private List<Response> responses;

    public Topic(RegisterTopic registerTopic) {
        this.title = registerTopic.getTitle();
        this.message = registerTopic.getMessage();

    }
    public Topic updateTopic(UpdateTopic updateTopic) {
        if(updateTopic.getTitle()!=null){
            this.title = updateTopic.getTitle();
        }
        if(updateTopic.getMessage()!=null){
            this.message = updateTopic.getMessage();
        }
        return this;
    }
    public void deleteTopic() {
        this.status = false;
    }
}
