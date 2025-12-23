// src/main/java/com/beacon/Achievements/AchievementsDTO.java
package com.beacon.Achievements;

import com.beacon.CustomEnums.conditionType;

public class AchievementsDTO {

    private Long id;
    private String title;
    private String description;
    private String icon;
    private conditionType conditionType;
    private Boolean isActive;

    public AchievementsDTO() {
    }

    public AchievementsDTO(Long id,
                           String title,
                           String description,
                           String icon,
                           conditionType conditionType,
                           Boolean isActive) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.icon = icon;
        this.conditionType = conditionType;
        this.isActive = isActive;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public conditionType getConditionType() {
        return conditionType;
    }

    public void setConditionType(conditionType conditionType) {
        this.conditionType = conditionType;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }
}