package com.beacon.Assigments.AssigmentSubmission.Services;

import com.beacon.Assigments.AssigmentSubmission.AssignmentSubmission;
import com.beacon.Assigments.AssigmentSubmission.AssigmentSubmissionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AssignmentSubmissionServiceImpl implements AssignmentSubmissionService {

    private final AssigmentSubmissionRepository submissionRepository;

    public AssignmentSubmissionServiceImpl(AssigmentSubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    @Override
    public AssignmentSubmission create(AssignmentSubmission submission) {
        return submissionRepository.save(submission);
    }

    @Override
    public AssignmentSubmission update(Long id, AssignmentSubmission submission) {
        AssignmentSubmission existing = submissionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("AssignmentSubmission not found: " + id));

        existing.setAssignment(submission.getAssignment());
        existing.setUser(submission.getUser());
        existing.setSubmissionContent(submission.getSubmissionContent());
        existing.setStatus(submission.getStatus());
        existing.setFeedback(submission.getFeedback());

        return submissionRepository.save(existing);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AssignmentSubmission> getById(Long id) {
        return submissionRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AssignmentSubmission> getAll() {
        return submissionRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        submissionRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsById(Long id) {
        return submissionRepository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AssignmentSubmission> getByUserId(Long userId) {
        return submissionRepository.findByUser_Id(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AssignmentSubmission> getByAssignmentId(Long assignmentId) {
        return submissionRepository.findByAssignment_Id(assignmentId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AssignmentSubmission> getByUserIdAndAssignmentId(Long userId, Long assignmentId) {
        return submissionRepository.findByUser_IdAndAssignment_Id(userId, assignmentId);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByUserIdAndAssignmentId(Long userId, Long assignmentId) {
        return submissionRepository.existsByUser_IdAndAssignment_Id(userId, assignmentId);
    }
}