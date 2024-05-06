package com.minden.exercise.mindenrestapi.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "courses")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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
}
