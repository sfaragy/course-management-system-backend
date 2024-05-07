package com.minden.exercise.mindenrestapi.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
public class CourseRegistrationDto {

    @NonNull
    private Long courseId;

    @NonNull
    private Long studentId;


    public CourseRegistrationDto()
    {

    }

    public CourseRegistrationDto(@NonNull Long courseId, @NonNull Long studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }
}
