// `src/main/java/com/beacon/Assigments/AssigmentSubmission/AssigmentSubmissionRepository.java`
package com.beacon.Assigments.AssigmentSubmission;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssigmentSubmissionRepository extends JpaRepository<AssignmentSubmission, Long> {

    List<AssignmentSubmission> findByAssignment_Id(Long assignmentId);

    List<AssignmentSubmission> findByUser_Id(Long userId);

    // Match service method naming: userId first, then assignmentId
    List<AssignmentSubmission> findByUser_IdAndAssignment_Id(Long userId, Long assignmentId);

    boolean existsByUser_IdAndAssignment_Id(Long userId, Long assignmentId);
}