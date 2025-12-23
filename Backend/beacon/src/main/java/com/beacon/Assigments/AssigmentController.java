// src/main/java/com/beacon/Assigments/AssigmentController.java
    package com.beacon.Assigments;

    import com.beacon.Assigments.Services.AssigmentService;
    import com.beacon.Modules.Module;
    import com.beacon.Users.User;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Optional;
    import java.util.stream.Collectors;

    @RestController
    @RequestMapping("/api")
    public class AssigmentController {

        private final AssigmentService assigmentService;

        public AssigmentController(AssigmentService assigmentService) {
            this.assigmentService = assigmentService;
        }

        @PostMapping("/assigments")
        public ResponseEntity<AssigmentDTO> create(@RequestBody AssigmentDTO dto) {
            Assigment created = assigmentService.create(fromDto(dto));
            return ResponseEntity.status(HttpStatus.CREATED).body(toDto(created));
        }

        @PutMapping("/assigments/{id}")
        public ResponseEntity<AssigmentDTO> update(@PathVariable Long id, @RequestBody AssigmentDTO dto) {
            Assigment updated = assigmentService.update(id, fromDto(dto));
            return ResponseEntity.ok(toDto(updated));
        }

        @GetMapping("/assigments/{id}")
        public ResponseEntity<AssigmentDTO> getById(@PathVariable Long id) {
            Optional<AssigmentDTO> dto = assigmentService.getById(id).map(this::toDto);
            return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @GetMapping("/assigments")
        public ResponseEntity<List<AssigmentDTO>> getAll(
                @RequestParam(name = "moduleId", required = false) Long moduleId,
                @RequestParam(name = "mentorId", required = false) Long mentorId
        ) {
            List<Assigment> assigments;
            if (moduleId != null && mentorId != null) {
                assigments = assigmentService.getByModuleIdAndMentorId(moduleId, mentorId);
            } else if (moduleId != null) {
                assigments = assigmentService.getByModuleId(moduleId);
            } else if (mentorId != null) {
                assigments = assigmentService.getByMentorId(mentorId);
            } else {
                assigments = assigmentService.getAll();
            }

            List<AssigmentDTO> result = assigments.stream().map(this::toDto).collect(Collectors.toList());
            return ResponseEntity.ok(result);
        }

        @DeleteMapping("/assigments/{id}")
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteById(@PathVariable Long id) {
            assigmentService.deleteById(id);
        }

        @GetMapping("/modules/{moduleId}/assigments")
        public ResponseEntity<List<AssigmentDTO>> getByModule(@PathVariable Long moduleId) {
            List<AssigmentDTO> result = assigmentService.getByModuleId(moduleId)
                    .stream()
                    .map(this::toDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(result);
        }

        @GetMapping("/mentors/{mentorId}/assigments")
        public ResponseEntity<List<AssigmentDTO>> getByMentor(@PathVariable Long mentorId) {
            List<AssigmentDTO> result = assigmentService.getByMentorId(mentorId)
                    .stream()
                    .map(this::toDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(result);
        }

        @GetMapping("/modules/{moduleId}/mentors/{mentorId}/assigments")
        public ResponseEntity<List<AssigmentDTO>> getByModuleAndMentor(@PathVariable Long moduleId, @PathVariable Long mentorId) {
            List<AssigmentDTO> result = assigmentService.getByModuleIdAndMentorId(moduleId, mentorId)
                    .stream()
                    .map(this::toDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(result);
        }

        // ---- DTO mapping ----

        private AssigmentDTO toDto(Assigment assigment) {
            return new AssigmentDTO(
                    assigment.getId(),
                    assigment.getTitle(),
                    assigment.getDescription(),
                    assigment.getModule() != null ? assigment.getModule().getId() : null,
                    assigment.getMentor() != null ? assigment.getMentor().getId() : null,
                    assigment.getDeadline()
            );
        }

        private Assigment fromDto(AssigmentDTO dto) {
            Assigment assigment = new Assigment();
            assigment.setId(dto.getId());
            assigment.setTitle(dto.getTitle());
            assigment.setDescription(dto.getDescription());
            assigment.setDeadline(dto.getDeadline());

            if (dto.getModuleId() != null) {
                Module module = new Module();
                module.setId(dto.getModuleId());
                assigment.setModule(module);
            }

            if (dto.getMentorId() != null) {
                User mentor = new User();
                mentor.setId(dto.getMentorId());
                assigment.setMentor(mentor);
            }

            return assigment;
        }
    }