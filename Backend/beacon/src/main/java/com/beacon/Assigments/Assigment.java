
    package com.beacon.Assigments;

    import com.beacon.Assigments.AssigmentSubmission.AssignmentSubmission;
    import com.beacon.Modules.Module;
    import com.beacon.Users.User;
    import jakarta.persistence.*;

    import java.io.Serializable;
    import java.time.LocalDateTime;
    import java.util.ArrayList;
    import java.util.List;

    @Entity
    @Table(name = "assigments")
    public class Assigment implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String title;

        @Lob
        @Column(nullable = true)
        private String description;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "module_id", nullable = false)
        private Module module;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "mentor_id", nullable = false)
        private User mentor;

        @Column(nullable = true)
        private LocalDateTime deadline;

        @OneToMany(mappedBy = "assignment", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
        private List<AssignmentSubmission> submissions = new ArrayList<>();

        public Assigment() {}

        public Assigment(Long id, String title, String description, Module module, User mentor, LocalDateTime deadline) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.module = module;
            this.mentor = mentor;
            this.deadline = deadline;
        }

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }

        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }

        public Module getModule() { return module; }
        public void setModule(Module module) { this.module = module; }

        public User getMentor() { return mentor; }
        public void setMentor(User mentor) { this.mentor = mentor; }

        public LocalDateTime getDeadline() { return deadline; }
        public void setDeadline(LocalDateTime deadline) { this.deadline = deadline; }

        public List<AssignmentSubmission> getSubmissions() { return submissions; }
        public void setSubmissions(List<AssignmentSubmission> submissions) { this.submissions = submissions; }
    }