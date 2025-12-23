package com.beacon.Modules;

import com.beacon.Courses.Course;
import com.beacon.Modules.Services.ModuleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ModuleController {

    private final ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    // ---- CRUD by Module id ----

    @PostMapping("/modules")
    public ResponseEntity<ModuleDTO> create(@RequestBody ModuleDTO dto) {
        Module created = moduleService.create(fromDto(dto));
        return ResponseEntity.status(HttpStatus.CREATED).body(toDto(created));
    }

    @PutMapping("/modules/{id}")
    public ResponseEntity<ModuleDTO> update(@PathVariable Long id, @RequestBody ModuleDTO dto) {
        Module updated = moduleService.update(id, fromDto(dto));
        return ResponseEntity.ok(toDto(updated));
    }

    @GetMapping("/modules/{id}")
    public ResponseEntity<ModuleDTO> getById(@PathVariable Long id) {
        Optional<ModuleDTO> dto = moduleService.getById(id).map(this::toDto);
        return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/modules")
    public ResponseEntity<List<ModuleDTO>> getAll() {
        List<ModuleDTO> result = moduleService.getAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/modules/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        moduleService.deleteById(id);
    }

    // ---- Resource-oriented course scope ----

    @GetMapping("/courses/{courseId}/modules")
    public ResponseEntity<List<ModuleDTO>> getByCourse(@PathVariable Long courseId) {
        List<ModuleDTO> result = moduleService.getByCourseId(courseId)
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(result);
    }

    // ---- DTO mapping ----

    private ModuleDTO toDto(Module module) {
        return new ModuleDTO(
                module.getId(),
                module.getTitle(),
                module.getContent(),
                module.getCourse() != null ? module.getCourse().getId() : null,
                module.getOrderNumber(),
                module.getEstimatedTime()
        );
    }

    private Module fromDto(ModuleDTO dto) {
        Module module = new Module();
        module.setId(dto.getId());
        module.setTitle(dto.getTitle());
        module.setContent(dto.getContent());
        module.setOrderNumber(dto.getOrderNumber());
        module.setEstimatedTime(dto.getEstimatedTime());

        if (dto.getCourseId() != null) {
            Course c = new Course();
            c.setId(dto.getCourseId());
            module.setCourse(c);
        }

        return module;
    }
}