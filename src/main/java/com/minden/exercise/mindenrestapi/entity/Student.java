package com.minden.exercise.mindenrestapi.entity;

import com.minden.exercise.mindenrestapi.repository.StudentRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_email", unique = true)
    private String studentEmail;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "status", columnDefinition = "integer default 0")
    private Integer status;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "date_updated")
    private Date dateUpdated;

    @ManyToMany(mappedBy = "student")
    private Set<CourseRegistration> registrations;
}
