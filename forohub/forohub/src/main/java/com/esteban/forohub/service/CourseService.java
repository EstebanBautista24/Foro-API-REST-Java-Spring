package com.esteban.forohub.service;

import com.esteban.forohub.model.Course;
import com.esteban.forohub.model.DTO.RegisterCourse;
import com.esteban.forohub.repository.ICourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    private ICourseRepository courseRepository;
    public CourseService(ICourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
    public Course saveCourse(RegisterCourse course) {
        return courseRepository.save(new Course(course));
    }
}
