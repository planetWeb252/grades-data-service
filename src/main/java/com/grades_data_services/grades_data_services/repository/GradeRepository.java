package com.grades_data_services.grades_data_services.repository;

import com.grades_data_services.grades_data_services.models.Course;
import com.grades_data_services.grades_data_services.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    Object findCourseByCourse(Course course);
}
