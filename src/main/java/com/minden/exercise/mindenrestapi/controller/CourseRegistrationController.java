package com.minden.exercise.mindenrestapi.controller;

import com.minden.exercise.mindenrestapi.dto.CourseRegistrationDto;
import com.minden.exercise.mindenrestapi.entity.CourseRegistration;
import com.minden.exercise.mindenrestapi.service.CourseRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/minden-api/v1/course-registration")
public class CourseRegistrationController {

    @Autowired
    private CourseRegistrationService courseRegistrationService;

    @PostMapping
    public ResponseEntity<String> registerCourse(@RequestBody CourseRegistrationDto courseRegistrationDto) {
        CourseRegistration courseRegistration = courseRegistrationService.registerCourse(courseRegistrationDto);

        if (courseRegistration != null) {
            return new ResponseEntity<>("Successfully signed up for course " + courseRegistration.getCourse().getCourseName(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Course registration already exists", HttpStatus.BAD_REQUEST);
        }
    }
}