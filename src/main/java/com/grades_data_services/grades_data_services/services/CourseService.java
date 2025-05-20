package com.grades_data_services.grades_data_services.services;

import com.grades_data_services.grades_data_services.DTO.CreateCourseRequestDTO;
import com.grades_data_services.grades_data_services.DTO.GradeRequestDTO;
import com.grades_data_services.grades_data_services.models.Course;
import com.grades_data_services.grades_data_services.models.Grade;
import com.grades_data_services.grades_data_services.repository.CourseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public ResponseEntity<?> getGradesOnCourseCode(String courseCode) {
        // check if course exist
        Course course = courseRepository.findByCourseCode(courseCode);
        if (course == null) {
            return ResponseEntity.status(404).body("Course not found");
        }
        // IF EXITS course, get the list of grades
        List<Grade> grades = course.getGrades();
        // ig list of grades is empty, return 404
        if (grades.isEmpty()) {
            return ResponseEntity.status(404).body("No grades found for this course");
        }
        // if list of grades is not empty, return the list of grades
        return ResponseEntity.ok(grades);
    }

    public ResponseEntity<?> createdCourse(CreateCourseRequestDTO dto) {
        // check if course exist
        Course course = courseRepository.findByCourseCode(dto.getCourseCode());
        // if exist
        if (course != null) {
            return ResponseEntity.status(400).body("Course already exists");
        }
        // if course does not exist, create a new course
        Course newCourse = new Course();
        newCourse.setCourseCode(dto.getCourseCode());
        newCourse.setCourseName(dto.getCourseName());
        return ResponseEntity.status(201).body("Course created successfully");
    }
}
