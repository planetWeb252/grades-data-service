package com.grades_data_services.grades_data_services.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double grade;
    private Long idStudent;
    @ManyToOne
    @JoinColumn(name = "course_code", referencedColumnName = "courseCode")
    @JsonBackReference
    private Course course;
}
