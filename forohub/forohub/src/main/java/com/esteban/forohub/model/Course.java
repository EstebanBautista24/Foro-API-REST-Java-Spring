package com.esteban.forohub.model;

import com.esteban.forohub.model.DTO.RegisterCourse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCourse;
    private String name;
    private String category;
    @OneToMany(mappedBy = "course")
    private List<Topic> topics;

    public Course(RegisterCourse registerCourse) {
        this.name = registerCourse.getName();
        this.category = registerCourse.getCategory();
    }
}
