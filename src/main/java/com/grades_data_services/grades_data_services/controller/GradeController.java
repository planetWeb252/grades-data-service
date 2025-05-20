package com.grades_data_services.grades_data_services.controller;

import com.grades_data_services.grades_data_services.DTO.GradeRequestDTO;
import com.grades_data_services.grades_data_services.models.Grade;
import com.grades_data_services.grades_data_services.repository.GradeRepository;
import com.grades_data_services.grades_data_services.services.GradeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/grade")
public class GradeController {
    private final GradeRepository  gradeRepository;
    private final GradeService gradeService;
    public GradeController(GradeRepository gradeRepository, GradeService gradeService) {
        this.gradeRepository = gradeRepository;
        this.gradeService = gradeService;
    }


    @GetMapping("/all")
    public ResponseEntity<?> getAllGrades(){
     return ResponseEntity.ok(gradeRepository.findAll());
    }
    @PostMapping
    public ResponseEntity<Grade> createdGrade(@RequestBody GradeRequestDTO dto){
        Grade savedGrade=gradeService.createdGrade(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedGrade);
    }
}
