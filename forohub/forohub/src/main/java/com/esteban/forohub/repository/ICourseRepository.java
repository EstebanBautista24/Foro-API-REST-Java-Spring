package com.esteban.forohub.repository;

import com.esteban.forohub.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course, Long> {
}
