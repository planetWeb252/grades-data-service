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
            return ResponseEntity.status(404).body("Course with code " + courseCode + " not found");
        }
        // Get the grades for the course
        Optional<List<Course>> grades = courseRepository.findGradesByCourseCode(courseCode);
        // Return the grades
        return ResponseEntity.ok(grades);

    }



}
