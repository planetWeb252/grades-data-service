package com.grades_data_services.grades_data_services.services;

import com.grades_data_services.grades_data_services.DTO.GradeRequestDTO;
import com.grades_data_services.grades_data_services.DTO.StudenDtoCallMicro;
import com.grades_data_services.grades_data_services.models.Course;
import com.grades_data_services.grades_data_services.models.Grade;
import com.grades_data_services.grades_data_services.repository.CourseRepository;
import com.grades_data_services.grades_data_services.repository.GradeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class GradeService {
    private final GradeRepository gradeRepository;
    private final CourseRepository courseRepository;
    private final RestTemplate restTemplate;

    public GradeService(GradeRepository gradeRepository, CourseRepository courseRepository,RestTemplate restTemplate) {
        this.gradeRepository = gradeRepository;
        this.courseRepository = courseRepository;
        this.restTemplate = restTemplate;
    }

    public Grade createdGrade(GradeRequestDTO dto) {


        // call  info-student service to check if student exist

        String url="http://student-info-service/api/students/" + dto.getStudentId();
        ResponseEntity<StudenDtoCallMicro> response = restTemplate.getForEntity(url, StudenDtoCallMicro.class);
        if(!response.getStatusCode().is2xxSuccessful()|| response.getBody()==null){
            throw new RuntimeException("Student not found");
        }
        //  if student exist
        // check if exit course
        Course course = courseRepository.findById(dto.getCourseCode()).orElseThrow(
                () -> new RuntimeException("Course not found"));


        Grade grade = new Grade();
        grade.setGrade(dto.getGrade());
        grade.setIdStudent(dto.getStudentId());
        grade.setCourse(course);
        return gradeRepository.save(grade);
    }
}
