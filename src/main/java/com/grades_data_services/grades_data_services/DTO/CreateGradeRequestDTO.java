package com.grades_data_services.grades_data_services.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateGradeRequestDTO {
    //Grade
    private double grade;
    private Long idStudent;
    //Course
    private String courseCode;
}
