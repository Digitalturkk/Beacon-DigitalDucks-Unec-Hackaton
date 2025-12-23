// `src/main/java/com/beacon/Assigments/AssigmentSubmission/AssignmentSubmission.java`
package com.beacon.Assigments.AssigmentSubmission;

import com.beacon.Assigments.Assigment;
import com.beacon.CustomEnums.AssigmentStatus;
import com.beacon.Users.User;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "assignment_submissions")
public class AssignmentSubmission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "assignment_id", nullable = false)
    private Assigment assignment;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Lob
    @Column(name = "submission_content", nullable = false)
    private String submissionContent;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AssigmentStatus status;

    @Lob
    @Column(nullable = true)
    private String feedback;

    public AssignmentSubmission() {}

    public AssignmentSubmission(Assigment assignment, User user, String submissionContent, AssigmentStatus status, String feedback) {
        this.assignment = assignment;
        this.user = user;
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

    public Assigment getAssignment() { return assignment; }
    public void setAssignment(Assigment assignment) { this.assignment = assignment; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getSubmissionContent() { return submissionContent; }
    public void setSubmissionContent(String submissionContent) { this.submissionContent = submissionContent; }

    public AssigmentStatus getStatus() { return status; }
    public void setStatus(AssigmentStatus status) { this.status = status; }

    public String getFeedback() { return feedback; }
    public void setFeedback(String feedback) { this.feedback = feedback; }
}