package com.esteban.forohub.model.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterTopic {
    @NotBlank
    private String title;
    @NotBlank
    private String message;
    @NotNull
    private Long idUser;
    @NotNull
    private Long idCourse;
}
