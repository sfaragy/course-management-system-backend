package com.minden.exercise.mindenrestapi.service;

import com.minden.exercise.mindenrestapi.dto.CourseRegistrationDto;
import com.minden.exercise.mindenrestapi.entity.Course;
import com.minden.exercise.mindenrestapi.entity.CourseRegistration;
import com.minden.exercise.mindenrestapi.entity.Student;
import com.minden.exercise.mindenrestapi.repository.CourseRepository;
import com.minden.exercise.mindenrestapi.repository.StudentRepository;
import com.minden.exercise.mindenrestapi.repository.CourseRegistrationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseRegistrationService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRegistrationRepository courseRegistrationRepository;

    public CourseRegistration registerCourse(CourseRegistrationDto courseRegistrationDto) {
        // Validate inputs (e.g., course id, student id)

        Course course = courseRepository.findById(courseRegistrationDto.getCourseId())
                .orElseThrow(() -> new EntityNotFoundException("Course not found"));

        Student student = studentRepository.findById(courseRegistrationDto.getStudentId())
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));

        CourseRegistration courseRegistration = new CourseRegistration();
        courseRegistration.setCourse(course);
        courseRegistration.setStudent(student);
        courseRegistration.setRegistrationDate(courseRegistrationDto.getRegistrationDate());

        return courseRegistrationRepository.save(courseRegistration);
    }
}
