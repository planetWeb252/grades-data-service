package com.grades_data_services.grades_data_services.controller;

import com.grades_data_services.grades_data_services.repository.GradeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/grade")
public class GradeController {
    private final GradeRepository  gradeRepository;
    public GradeController(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }


    @GetMapping("/all")
    public ResponseEntity<?> getAllGrades(){
     return ResponseEntity.ok(gradeRepository.findAll());
    }
}
