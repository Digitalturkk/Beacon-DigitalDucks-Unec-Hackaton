package com.beacon.Courses;

import com.beacon.Courses.Services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // ---- CRUD by Course id ----

    @PostMapping("/courses")
    public ResponseEntity<CourseDTO> create(@RequestBody CourseDTO dto) {
        Course created = courseService.create(fromDto(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(toDto(created));
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<CourseDTO> update(@PathVariable Long id, @RequestBody CourseDTO dto) {
        Course updated = courseService.update(id, fromDto(dto));
        return ResponseEntity.ok(toDto(updated));
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<CourseDTO> getById(@PathVariable Long id) {
        Optional<CourseDTO> dto = courseService.getById(id).map(this::toDto);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/courses")
    public ResponseEntity<List<CourseDTO>> getAll() {
        List<CourseDTO> result = courseService.getAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/courses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        courseService.deleteById(id);
    }

    // ---- DTO mapping ----

    private CourseDTO toDto(Course course) {
        return new CourseDTO(
                course.getId(),
                course.getTitle(),
                course.getDescription(),
                course.getDepartment(),
                course.getIsActive(),
                course.getCreatedBy()
        );
    }

    private Course fromDto(CourseDTO dto) {
        Course course = new Course();
        course.setId(dto.getId());
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setDepartment(dto.getDepartment());
        course.setIsActive(dto.getIsActive());
        course.setCreatedBy(dto.getCreatedBy());
        return course;
    }
}