package org.example.courseproject.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "st_group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "gr_id")
    private Long id;
    private String title;
    @Column(name = "level")
    private String levelOfEducation;
    @Column(name = "direction")
    private String direction;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    public Group() {
    }

    public Group(String title, String levelOfEducation, String direction, Faculty faculty) {
        this.title = title;
        this.levelOfEducation = levelOfEducation;
        this.direction = direction;
        this.faculty = faculty;
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

    public String getLevelOfEducation() {
        return levelOfEducation;
    }

    public void setLevelOfEducation(String levelOfEducation) {
        this.levelOfEducation = levelOfEducation;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
}
