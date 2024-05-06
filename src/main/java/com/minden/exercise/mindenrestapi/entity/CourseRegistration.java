package com.minden.exercise.mindenrestapi.entity;

import com.minden.exercise.mindenrestapi.enums.StudentsCourseStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course_registration")
public class CourseRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StudentsCourseStatusEnum status;

}
