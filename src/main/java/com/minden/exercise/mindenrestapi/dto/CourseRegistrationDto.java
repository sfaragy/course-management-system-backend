package com.minden.exercise.mindenrestapi.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CourseRegistrationDto {

    private Long courseId;
    private Long studentId;

    public CourseRegistrationDto(Long courseId, Long studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }

}
