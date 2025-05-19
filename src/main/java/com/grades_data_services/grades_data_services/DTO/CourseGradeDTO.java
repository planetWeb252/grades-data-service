package com.grades_data_services.grades_data_services.DTO;

import com.grades_data_services.grades_data_services.models.Grade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseGradeDTO {
    private String courseCode;
    private String courseName;
    private List<Grade> grade;
    private Long idStudent;

    public CourseGradeDTO(String courseCode, String courseName, List<Grade> grade) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.grade = grade;
    }
}
