package com.esteban.forohub.Controller;


import com.esteban.forohub.model.Course;
import com.esteban.forohub.model.DTO.RegisterCourse;
import com.esteban.forohub.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<Course> registerCourse(@RequestBody @Valid RegisterCourse registerCourse) {
            Course course = courseService.saveCourse(registerCourse);
            HttpHeaders headers = new HttpHeaders();
            return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(course);
    }
}
