package com.esteban.forohub.model.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponse {
    @NotBlank
    private String message;
    @NotNull
    private Long idAuthor;
    @NotNull
    private Long idTopic;
    @NotBlank
    private String solution;
}
