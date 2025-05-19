package com.grades_data_services.grades_data_services.services;

import com.grades_data_services.grades_data_services.models.Course;
import com.grades_data_services.grades_data_services.repository.CourseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.status;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public ResponseEntity<?> getGradesOnCourseCode(String courseCode) {
        // Check if the course exists
        if (courseRepository.findByCourseCode(courseCode) == null) {
            // Return 404 if the course does not exist
            return status(404).body("Course not found");
        }
        Optional<List<Course>> optionalGrades=courseRepository.findGradesByCourseCode(courseCode);
        if (optionalGrades.isPresent()) {
            // Get the course
            Course course = courseRepository.findByCourseCode(courseCode);
            // Get the grades
            List<Course> grades = courseRepository.findGradesByCourseCode(courseCode).get();
            // Return the grades
            return status(200).body(grades);
        } else {
            // Return 404 if the course does not exist
            return status(404).body("Course not found");
        }

    }



}
