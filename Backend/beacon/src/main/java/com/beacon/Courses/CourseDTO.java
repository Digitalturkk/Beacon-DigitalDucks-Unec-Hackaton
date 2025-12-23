package com.beacon.Courses;

public class CourseDTO {

    private Long id;
    private String title;
    private String description;
    private String department;
    private Boolean isActive;
    private String createdBy;

    public CourseDTO() {
    }

    public CourseDTO(Long id, String title, String description, String department, Boolean isActive, String createdBy) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.department = department;
        this.isActive = isActive;
        this.createdBy = createdBy;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}