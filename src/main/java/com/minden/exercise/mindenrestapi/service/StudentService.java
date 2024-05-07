package com.minden.exercise.mindenrestapi.service;

import com.minden.exercise.mindenrestapi.entity.CourseRegistration;
import com.minden.exercise.mindenrestapi.entity.Student;
import com.minden.exercise.mindenrestapi.repository.CourseRegistrationRepository;
import com.minden.exercise.mindenrestapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private final CourseRegistrationRepository courseRegistrationRepository;

    public List<Student> getAllStudents(){
        return (List<Student>) studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return (Optional<Student>) studentRepository.findById(id);
    }

    @Autowired
    public StudentService(CourseRegistrationRepository courseRegistrationRepository) {
        this.courseRegistrationRepository = courseRegistrationRepository;
    }

    public List<CourseRegistration> getStudentCoursesById(Long studentId) {
        return courseRegistrationRepository.findByStudentId(studentId);
    }
}
