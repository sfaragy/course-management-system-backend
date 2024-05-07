package com.minden.exercise.mindenrestapi.dto;

import com.minden.exercise.mindenrestapi.enums.StudentsCourseStatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CoursesDTO {
    private Long registration_id;
    private Long course_id;
    private String course_name;
    private StudentsCourseStatusEnum status;
    private Date registration_date;

    public CoursesDTO() {
    }

    public CoursesDTO(
            Long registration_id,
            Long course_id,
            String course_name,
            StudentsCourseStatusEnum status,
            Date registration_date
    ) {
        this.registration_id = registration_id;
        this.course_id = course_id;
        this.course_name = course_name;
        this.status = status;
        this.registration_date = registration_date;
    }
}
