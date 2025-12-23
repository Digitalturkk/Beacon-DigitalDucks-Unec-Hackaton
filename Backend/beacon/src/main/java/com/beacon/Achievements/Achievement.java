// src/main/java/com/beacon/Achievements/Achievement.java
    package com.beacon.Achievements;

    import com.beacon.Achievements.UserAchievement.UserAchievement;
    import com.beacon.CustomEnums.conditionType;
    import jakarta.persistence.*;

    import java.io.Serializable;
    import java.util.ArrayList;
    import java.util.List;

    @Entity
    @Table(name = "achievements")
    public class Achievement implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String title;

        @Lob
        @Column(nullable = true)
        private String description;

        @Column(nullable = true)
        private String icon; // URL or badge identifier

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private conditionType conditionType;

        @Column(nullable = false)
        private Boolean isActive = true;

        @OneToMany(mappedBy = "achievement", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
        private List<UserAchievement> userAchievements = new ArrayList<>();

        public Achievement() { }

        public Achievement(Long id, String title, String description, String icon, conditionType conditionType, Boolean isActive) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.icon = icon;
            this.conditionType = conditionType;
            this.isActive = isActive;
        }

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }

        public String getIcon() { return icon; }
        public void setIcon(String icon) { this.icon = icon; }

        public conditionType getConditionType() { return conditionType; }
        public void setConditionType(conditionType conditionType) { this.conditionType = conditionType; }

        public Boolean getIsActive() { return isActive; }
        public void setIsActive(Boolean active) { isActive = active; }

        public List<UserAchievement> getUserAchievements() { return userAchievements; }
        public void setUserAchievements(List<UserAchievement> userAchievements) { this.userAchievements = userAchievements; }
    }