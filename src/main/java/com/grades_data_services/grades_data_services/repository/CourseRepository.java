package com.grades_data_services.grades_data_services.repository;

import com.grades_data_services.grades_data_services.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
     Course findByCourseCode(String courseCode);
     Optional<Course> findById(String courseCode);

     Optional<List<Course>> findCouseByCourseCode(String coursecode);
}
