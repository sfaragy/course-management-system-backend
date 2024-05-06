package com.minden.exercise.mindenrestapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name", nullable = false, unique = true)
    private String courseName;

    // No need for now the Column definition migration. columnDefinition = "INTEGER USING CAST(credit AS INTEGER)"
    @Column(name = "credit")
    private Integer credit;

    @Column(name = "status", columnDefinition = "integer default 0")
    private Integer status;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "date_updated")
    private Date dateUpdated;

    @ManyToMany(mappedBy = "course")
    private Set<CourseRegistration> registrations;

}
