// src/main/java/com/beacon/Assigments/AssigmentSubmission/AssigmentSubmissionController.java
                        package com.beacon.Assigments.AssigmentSubmission;

                        import com.beacon.Assigments.Assigment;
                        import com.beacon.Assigments.AssigmentSubmission.Services.AssignmentSubmissionService;
                        import com.beacon.Users.User;
                        import org.springframework.http.HttpStatus;
                        import org.springframework.http.ResponseEntity;
                        import org.springframework.web.bind.annotation.*;

                        import java.util.List;
                        import java.util.Optional;
                        import java.util.stream.Collectors;

                        @RestController
                        @RequestMapping("/api")
                        public class AssigmentSubmissionController {

                            private final AssignmentSubmissionService assignmentSubmissionService;

                            public AssigmentSubmissionController(AssignmentSubmissionService assignmentSubmissionService) {
                                this.assignmentSubmissionService = assignmentSubmissionService;
                            }

                            // ---- CRUD by submission id ----

                            @PostMapping("/assigment-submissions")
                            public ResponseEntity<AssigmentSubmissionDTO> create(@RequestBody AssigmentSubmissionDTO dto) {
                                AssignmentSubmission created = assignmentSubmissionService.create(fromDto(dto));
                                return ResponseEntity.status(HttpStatus.CREATED).body(toDto(created));
                            }

                            @PutMapping("/assigment-submissions/{id}")
                            public ResponseEntity<AssigmentSubmissionDTO> update(@PathVariable Long id, @RequestBody AssigmentSubmissionDTO dto) {
                                AssignmentSubmission updated = assignmentSubmissionService.update(id, fromDto(dto));
                                return ResponseEntity.ok(toDto(updated));
                            }

                            @GetMapping("/assigment-submissions/{id}")
                            public ResponseEntity<AssigmentSubmissionDTO> getById(@PathVariable Long id) {
                                Optional<AssigmentSubmissionDTO> dto = assignmentSubmissionService.getById(id).map(this::toDto);
                                return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
                            }

                            @GetMapping("/assigment-submissions")
                            public ResponseEntity<List<AssigmentSubmissionDTO>> getAll(
                                    @RequestParam(name = "assignmentId", required = false) Long assignmentId,
                                    @RequestParam(name = "userId", required = false) Long userId
                            ) {
                                List<AssignmentSubmission> submissions;

                                if (assignmentId != null && userId != null) {
                                    submissions = assignmentSubmissionService.getByUserIdAndAssignmentId(userId, assignmentId);
                                } else if (assignmentId != null) {
                                    submissions = assignmentSubmissionService.getByAssignmentId(assignmentId);
                                } else if (userId != null) {
                                    submissions = assignmentSubmissionService.getByUserId(userId);
                                } else {
                                    submissions = assignmentSubmissionService.getAll();
                                }

                                List<AssigmentSubmissionDTO> result = submissions.stream().map(this::toDto).collect(Collectors.toList());
                                return ResponseEntity.ok(result);
                            }

                            @DeleteMapping("/assigment-submissions/{id}")
                            @ResponseStatus(HttpStatus.NO_CONTENT)
                            public void deleteById(@PathVariable Long id) {
                                assignmentSubmissionService.deleteById(id);
                            }

                            // ---- Resource-oriented scopes ----

                            @GetMapping("/assigments/{assignmentId}/submissions")
                            public ResponseEntity<List<AssigmentSubmissionDTO>> getByAssignment(@PathVariable Long assignmentId) {
                                List<AssigmentSubmissionDTO> result = assignmentSubmissionService.getByAssignmentId(assignmentId)
                                        .stream()
                                        .map(this::toDto)
                                        .collect(Collectors.toList());
                                return ResponseEntity.ok(result);
                            }

                            @GetMapping("/users/{userId}/assigment-submissions")
                            public ResponseEntity<List<AssigmentSubmissionDTO>> getByUser(@PathVariable Long userId) {
                                List<AssigmentSubmissionDTO> result = assignmentSubmissionService.getByUserId(userId)
                                        .stream()
                                        .map(this::toDto)
                                        .collect(Collectors.toList());
                                return ResponseEntity.ok(result);
                            }

                            @GetMapping("/assigments/{assignmentId}/users/{userId}/submissions")
                            public ResponseEntity<List<AssigmentSubmissionDTO>> getByAssignmentAndUser(
                                    @PathVariable Long assignmentId,
                                    @PathVariable Long userId
                            ) {
                                List<AssigmentSubmissionDTO> result = assignmentSubmissionService.getByUserIdAndAssignmentId(userId, assignmentId)
                                        .stream()
                                        .map(this::toDto)
                                        .collect(Collectors.toList());
                                return ResponseEntity.ok(result);
                            }

                            // ---- DTO mapping ----

                            private AssigmentSubmissionDTO toDto(AssignmentSubmission submission) {
                                return new AssigmentSubmissionDTO(
                                        submission.getId(),
                                        submission.getAssignment() != null ? submission.getAssignment().getId() : null,
                                        submission.getUser() != null ? submission.getUser().getId() : null,
                                        submission.getSubmissionContent(),
                                        submission.getStatus(),
                                        submission.getFeedback()
                                );
                            }

                            private AssignmentSubmission fromDto(AssigmentSubmissionDTO dto) {
                                AssignmentSubmission submission = new AssignmentSubmission();
                                submission.setSubmissionContent(dto.getSubmissionContent());
                                submission.setStatus(dto.getStatus());
                                submission.setFeedback(dto.getFeedback());

                                if (dto.getAssignmentId() != null) {
                                    Assigment assigment = new Assigment();
                                    assigment.setId(dto.getAssignmentId());
                                    submission.setAssignment(assigment);
                                }

                                if (dto.getUserId() != null) {
                                    User user = new User();
                                    user.setId(dto.getUserId());
                                    submission.setUser(user);
                                }

                                return submission;
                            }
                        }