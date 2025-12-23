package com.beacon.Assigments.AssigmentSubmission;

import com.beacon.CustomEnums.AssigmentStatus;

public class AssigmentSubmissionDTO {

    private Long id;
    private Long assignmentId;
    private Long userId;
    private String submissionContent;
    private AssigmentStatus status;
    private String feedback;

    public AssigmentSubmissionDTO() {
    }

    public AssigmentSubmissionDTO(Long id,
                                  Long assignmentId,
                                  Long userId,
                                  String submissionContent,
                                  AssigmentStatus status,
                                  String feedback) {
        this.id = id;
        this.assignmentId = assignmentId;
        this.userId = userId;
        this.submissionContent = submissionContent;
        this.status = status;
        this.feedback = feedback;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Long assignmentId) {
        this.assignmentId = assignmentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSubmissionContent() {
        return submissionContent;
    }

    public void setSubmissionContent(String submissionContent) {
        this.submissionContent = submissionContent;
    }

    public AssigmentStatus getStatus() {
        return status;
    }

    public void setStatus(AssigmentStatus status) {
        this.status = status;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}