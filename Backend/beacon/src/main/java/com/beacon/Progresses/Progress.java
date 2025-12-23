// src/main/java/com/beacon/Progresses/Progress.java
    package com.beacon.Progresses;

    import com.beacon.Courses.Course;
    import com.beacon.Modules.Module;
    import com.beacon.Users.User;
    import com.beacon.CustomEnums.ProgressStatus;
    import jakarta.persistence.*;

    import java.io.Serializable;

    @Entity
    @Table(name = "progress")
    public class Progress implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "user_id", nullable = false)
        private User user;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "course_id", nullable = false)
        private Course course;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "module_id", nullable = false)
        private Module module;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private ProgressStatus status = ProgressStatus.NOT_STARTED;

        public Progress() { }

        public Progress(Long id, User user, Course course, Module module, ProgressStatus status) {
            this.id = id;
            this.user = user;
            this.course = course;
            this.module = module;
            this.status = status;
        }

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public User getUser() { return user; }
        public void setUser(User user) { this.user = user; }

        public Course getCourse() { return course; }
        public void setCourse(Course course) { this.course = course; }

        public Module getModule() { return module; }
        public void setModule(Module module) { this.module = module; }

        public ProgressStatus getStatus() { return status; }
        public void setStatus(ProgressStatus status) { this.status = status; }
    }