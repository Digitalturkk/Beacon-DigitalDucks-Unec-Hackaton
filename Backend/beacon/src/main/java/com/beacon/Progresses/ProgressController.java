// src/main/java/com/beacon/Progresses/ProgressController.java
package com.beacon.Progresses;

import com.beacon.Progresses.Services.ProgressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ProgressController {

    private final ProgressService progressService;

    public ProgressController(ProgressService progressService) {
        this.progressService = progressService;
    }

    // ---- CRUD by Progress id ----

    @PostMapping("/progress")
    public ResponseEntity<ProgressDTO> create(@RequestBody ProgressDTO dto) {
        Progress created = progressService.create(fromDto(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(toDto(created));
    }

    @PutMapping("/progress/{id}")
    public ResponseEntity<ProgressDTO> update(@PathVariable Long id, @RequestBody ProgressDTO dto) {
        Progress updated = progressService.update(id, fromDto(dto));
        return ResponseEntity.ok(toDto(updated));
    }

    @GetMapping("/progress/{id}")
    public ResponseEntity<ProgressDTO> getById(@PathVariable Long id) {
        Optional<ProgressDTO> dto = progressService.getById(id).map(this::toDto);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/progress")
    public ResponseEntity<List<ProgressDTO>> getAll() {
        List<ProgressDTO> result = progressService.getAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/progress/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        progressService.deleteById(id);
    }

    // ---- Resource-oriented filter paths ----

    @GetMapping("/users/{userId}/progress")
    public ResponseEntity<List<ProgressDTO>> getByUser(@PathVariable Long userId) {
        List<ProgressDTO> result = progressService.getByUserId(userId)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/courses/{courseId}/progress")
    public ResponseEntity<List<ProgressDTO>> getByCourse(@PathVariable Long courseId) {
        List<ProgressDTO> result = progressService.getByCourseId(courseId)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/modules/{moduleId}/progress")
    public ResponseEntity<List<ProgressDTO>> getByModule(@PathVariable Long moduleId) {
        List<ProgressDTO> result = progressService.getByModuleId(moduleId)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @GetMapping("/users/{userId}/modules/{moduleId}/progress")
    public ResponseEntity<ProgressDTO> getByUserAndModule(@PathVariable Long userId, @PathVariable Long moduleId) {
        Optional<ProgressDTO> dto = progressService.getByUserIdAndModuleId(userId, moduleId).map(this::toDto);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ---- DTO mapping (no repository access here; service expects entities) ----

    private ProgressDTO toDto(Progress progress) {
        return new ProgressDTO(
                progress.getId(),
                progress.getUser() != null ? progress.getUser().getId() : null,
                progress.getCourse() != null ? progress.getCourse().getId() : null,
                progress.getModule() != null ? progress.getModule().getId() : null,
                progress.getStatus()
        );
    }

    private Progress fromDto(ProgressDTO dto) {
        Progress progress = new Progress();
        progress.setId(dto.getId());

        if (dto.getUserId() != null) {
            com.beacon.Users.User u = new com.beacon.Users.User();
            u.setId(dto.getUserId());
            progress.setUser(u);
        }

        if (dto.getCourseId() != null) {
            com.beacon.Courses.Course c = new com.beacon.Courses.Course();
            c.setId(dto.getCourseId());
            progress.setCourse(c);
        }

        if (dto.getModuleId() != null) {
            com.beacon.Modules.Module m = new com.beacon.Modules.Module();
            m.setId(dto.getModuleId());
            progress.setModule(m);
        }

        progress.setStatus(dto.getStatus());
        return progress;
    }
}