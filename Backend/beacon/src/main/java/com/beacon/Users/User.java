// src/main/java/com/beacon/Users/User.java
package com.beacon.Users;

import com.beacon.Achievements.UserAchievement.UserAchievement;
import com.beacon.Assigments.Assigment;
import com.beacon.Assigments.AssigmentSubmission.AssignmentSubmission;
import com.beacon.Notifications.Notification;
import com.beacon.Progresses.Progress;
import com.beacon.CustomEnums.UserDepartment;
import com.beacon.CustomEnums.UserRole;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserDepartment department;

    private Boolean isActive;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserAchievement> achievements = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AssignmentSubmission> submissions = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notification> notifications = new ArrayList<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Progress> progresses = new ArrayList<>();

    @OneToMany(mappedBy = "mentor", fetch = FetchType.LAZY)
    private List<Assigment> mentoredAssigments = new ArrayList<>();

    public User(Long id, String name, String email, UserRole role, Boolean isActive, String password, UserDepartment department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.isActive = isActive;
        this.password = password;
        this.department = department;
    }

    public User() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public UserRole getRole() { return role; }
    public void setRole(UserRole role) { this.role = role; }

    public Boolean getActive() { return isActive; }
    public void setActive(Boolean active) { isActive = active; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public UserDepartment getDepartment() { return department; }
    public void setDepartment(UserDepartment department) { this.department = department; }

    public List<UserAchievement> getAchievements() { return achievements; }
    public void setAchievements(List<UserAchievement> achievements) { this.achievements = achievements; }

    public List<AssignmentSubmission> getSubmissions() { return submissions; }
    public void setSubmissions(List<AssignmentSubmission> submissions) { this.submissions = submissions; }

    public List<Notification> getNotifications() { return notifications; }
    public void setNotifications(List<Notification> notifications) { this.notifications = notifications; }

    public List<Progress> getProgresses() { return progresses; }
    public void setProgresses(List<Progress> progresses) { this.progresses = progresses; }

    public List<Assigment> getMentoredAssigments() { return mentoredAssigments; }
    public void setMentoredAssigments(List<Assigment> mentoredAssigments) { this.mentoredAssigments = mentoredAssigments; }
}