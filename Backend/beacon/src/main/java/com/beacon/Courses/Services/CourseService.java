package com.beacon.Courses.Services;

import com.beacon.Courses.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    Course create(Course course);

    Course update(Long id, Course course);

    Optional<Course> getById(Long id);

    List<Course> getAll();

    void deleteById(Long id);

    boolean existsById(Long id);

    List<Course> getByDepartment(String department);

    List<Course> getByIsActive(Boolean isActive);

    List<Course> getByDepartmentAndIsActive(String department, Boolean isActive);
}