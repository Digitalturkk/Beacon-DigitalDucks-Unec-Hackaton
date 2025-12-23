package com.beacon.Courses;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByDepartment(String department);

    List<Course> findByIsActive(Boolean isActive);

    List<Course> findByDepartmentAndIsActive(String department, Boolean isActive);
}