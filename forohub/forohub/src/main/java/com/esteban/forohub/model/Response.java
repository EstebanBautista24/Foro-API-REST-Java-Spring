package com.esteban.forohub.model;

import com.esteban.forohub.model.DTO.RegisterResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Response {
    @Column(unique = true, nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResponse;
    @Column(nullable = false)
    private String message;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "idTopic")
    private Topic topic;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "idUser")
    private User author;
    private String solution;

    public Response(RegisterResponse registerResponse) {
        this.message = registerResponse.getMessage();
        this.solution = registerResponse.getSolution();
    }
}
