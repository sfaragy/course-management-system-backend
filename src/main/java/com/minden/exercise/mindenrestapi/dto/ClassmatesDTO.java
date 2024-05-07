package com.minden.exercise.mindenrestapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassmatesDTO {
    private Long id;
    private String student_name;
    private String student_email;

    public ClassmatesDTO() {
    }

    public ClassmatesDTO(Long id, String student_name, String student_email) {
        this.id = id;
        this.student_name = student_name;
        this.student_email = student_email;
    }
}
