package com.beacon.Progresses;

import com.beacon.CustomEnums.ProgressStatus;

public class ProgressDTO {

    private Long id;
    private Long userId;
    private Long courseId;
    private Long moduleId;
    private ProgressStatus status;

    public ProgressDTO() {
    }

    public ProgressDTO(Long id, Long userId, Long courseId, Long moduleId, ProgressStatus status) {
        this.id = id;
        this.userId = userId;
        this.courseId = courseId;
        this.moduleId = moduleId;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getModuleId() {
        return moduleId;
    }

    public void setModuleId(Long moduleId) {
        this.moduleId = moduleId;
    }

    public ProgressStatus getStatus() {
        return status;
    }

    public void setStatus(ProgressStatus status) {
        this.status = status;
    }
}