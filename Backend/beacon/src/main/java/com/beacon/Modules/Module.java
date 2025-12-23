package com.beacon.Modules;

import com.beacon.Assigments.Assigment;
import com.beacon.Courses.Course;
import com.beacon.Progresses.Progress;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "modules")
public class Module implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    @Lob
    @Column(nullable = true)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(nullable = false)
    private Integer orderNumber;

    @Column(nullable = true)
    private Integer estimatedTime; // in minutes

            @OneToMany(mappedBy = "module", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
            private List<Assigment> assigments = new ArrayList<>();

            @OneToMany(mappedBy = "module", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
            private List<Progress> progresses = new ArrayList<>();

            public Module() { }

            public Module(Long id, String title, String content, Course course, Integer orderNumber, Integer estimatedTime) {
                this.id = id;
                this.title = title;
                this.content = content;
                this.course = course;
                this.orderNumber = orderNumber;
                this.estimatedTime = estimatedTime;
            }

            public Long getId() { return id; }
            public void setId(Long id) { this.id = id; }

            public String getTitle() { return title; }
            public void setTitle(String title) { this.title = title; }

            public String getContent() { return content; }
            public void setContent(String content) { this.content = content; }

            public Course getCourse() { return course; }
            public void setCourse(Course course) { this.course = course; }

            public Integer getOrderNumber() { return orderNumber; }
            public void setOrderNumber(Integer orderNumber) { this.orderNumber = orderNumber; }

            public Integer getEstimatedTime() { return estimatedTime; }
            public void setEstimatedTime(Integer estimatedTime) { this.estimatedTime = estimatedTime; }

            public List<Assigment> getAssigments() { return assigments; }
            public void setAssigments(List<Assigment> assigments) { this.assigments = assigments; }

            public List<Progress> getProgresses() { return progresses; }
            public void setProgresses(List<Progress> progresses) { this.progresses = progresses; }
}