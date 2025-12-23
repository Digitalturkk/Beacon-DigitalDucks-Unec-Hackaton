package com.beacon.Assigments.AssigmentSubmission.Services;

import com.beacon.Assigments.AssigmentSubmission.AssignmentSubmission;

import java.util.List;
import java.util.Optional;

public interface AssignmentSubmissionService {

    AssignmentSubmission create(AssignmentSubmission submission);

    AssignmentSubmission update(Long id, AssignmentSubmission submission);

    Optional<AssignmentSubmission> getById(Long id);

    List<AssignmentSubmission> getAll();

    void deleteById(Long id);

    boolean existsById(Long id);

    List<AssignmentSubmission> getByUserId(Long userId);

    List<AssignmentSubmission> getByAssignmentId(Long assignmentId);

    List<AssignmentSubmission> getByUserIdAndAssignmentId(Long userId, Long assignmentId);

    boolean existsByUserIdAndAssignmentId(Long userId, Long assignmentId);
}