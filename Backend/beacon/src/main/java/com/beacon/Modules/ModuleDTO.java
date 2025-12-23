package com.beacon.Modules;

public class ModuleDTO {

    private Long id;
    private String title;
    private String content;
    private Long courseId;
    private Integer orderNumber;
    private Integer estimatedTime;

    public ModuleDTO() {
    }

    public ModuleDTO(Long id, String title, String content, Long courseId, Integer orderNumber, Integer estimatedTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.courseId = courseId;
        this.orderNumber = orderNumber;
        this.estimatedTime = estimatedTime;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Integer estimatedTime) {
        this.estimatedTime = estimatedTime;
    }
}