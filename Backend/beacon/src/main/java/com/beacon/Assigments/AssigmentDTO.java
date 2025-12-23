package com.beacon.Assigments;

import java.time.LocalDateTime;

public class AssigmentDTO {

    private Long id;
    private String title;
    private String description;
    private Long moduleId;
    private Long mentorId;
    private LocalDateTime deadline;

    public AssigmentDTO() {
    }

    public AssigmentDTO(Long id, String title, String description, Long moduleId, Long mentorId, LocalDateTime deadline) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.moduleId = moduleId;
        this.mentorId = mentorId;
        this.deadline = deadline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public Long getMentorId() {
        return mentorId;
    }

    public void setMentorId(Long mentorId) {
        this.mentorId = mentorId;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }
}