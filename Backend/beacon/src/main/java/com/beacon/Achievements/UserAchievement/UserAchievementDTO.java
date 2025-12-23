// `src/main/java/com/beacon/Achievements/UserAchievement/UserAchievementDTO.java`
package com.beacon.Achievements.UserAchievement;

import java.time.LocalDateTime;

public class UserAchievementDTO {

    private Long id;
    private Long userId;
    private Long achievementId;
    private LocalDateTime receivedAt;

    public UserAchievementDTO() {
    }

    public UserAchievementDTO(Long id, Long userId, Long achievementId, LocalDateTime receivedAt) {
        this.id = id;
        this.userId = userId;
        this.achievementId = achievementId;
        this.receivedAt = receivedAt;
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

    public Long getAchievementId() {
        return achievementId;
    }

    public void setAchievementId(Long achievementId) {
        this.achievementId = achievementId;
    }

    public LocalDateTime getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(LocalDateTime receivedAt) {
        this.receivedAt = receivedAt;
    }
}