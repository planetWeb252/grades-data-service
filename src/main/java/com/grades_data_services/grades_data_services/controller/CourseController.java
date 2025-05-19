package com.grades_data_services.grades_data_services.controller;

import com.grades_data_services.grades_data_services.repository.CourseRepository;
import com.grades_data_services.grades_data_services.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    private final CourseRepository courseRepository;
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseRepository courseRepository, CourseService courseService) {
        this.courseRepository = courseRepository;
        this.courseService = courseService;
    }

    //get course by courseCode
    @GetMapping("/{courseCode}")
    public ResponseEntity<?> getCourseByCourseCode(@PathVariable String courseCode) {
        return ResponseEntity.ok(courseRepository.findByCourseCode(courseCode));
    }

    //get grades based on the course code
    @GetMapping("/grades/{courseCode}")
    public ResponseEntity<?> getGradesByCourseCode(@PathVariable String courseCode) {
       return courseService.getGradesOnCourseCode(courseCode);
    }
}
