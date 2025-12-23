package com.beacon.Courses.Services;

import com.beacon.Courses.Course;
import com.beacon.Courses.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course create(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course update(Long id, Course course) {
        Course existing = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Course not found: " + id));

        existing.setTitle(course.getTitle());
        existing.setDescription(course.getDescription());
        existing.setDepartment(course.getDepartment());
        existing.setIsActive(course.getIsActive());
        existing.setCreatedBy(course.getCreatedBy());
        existing.setModules(course.getModules());

        return courseRepository.save(existing);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Course> getById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Long id) {
        return courseRepository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> getByDepartment(String department) {
        return courseRepository.findByDepartment(department);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> getByIsActive(Boolean isActive) {
        return courseRepository.findByIsActive(isActive);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> getByDepartmentAndIsActive(String department, Boolean isActive) {
        return courseRepository.findByDepartmentAndIsActive(department, isActive);
    }
}