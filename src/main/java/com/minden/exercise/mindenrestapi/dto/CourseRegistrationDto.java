package com.minden.exercise.mindenrestapi.dto;

import java.util.Date;

public class CourseRegistrationDto {

    private Long courseId;
    private Long studentId;
    private Date registrationDate;

    public CourseRegistrationDto(Long courseId, Long studentId, Date registrationDate) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.registrationDate = registrationDate;
    }
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Long getCourseId() {
        return courseId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

}
