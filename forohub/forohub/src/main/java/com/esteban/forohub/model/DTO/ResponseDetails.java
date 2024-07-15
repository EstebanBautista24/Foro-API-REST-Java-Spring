package com.esteban.forohub.model.DTO;


import com.esteban.forohub.model.Response;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseDetails {

    private String message;
    private String author;
    private String solution;

    public ResponseDetails(Response response){
        this.message = response.getMessage();
        this.author = response.getAuthor().getName();
        this.solution = response.getSolution();
    }
}
