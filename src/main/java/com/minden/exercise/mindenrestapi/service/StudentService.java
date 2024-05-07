package com.minden.exercise.mindenrestapi.service;

import com.minden.exercise.mindenrestapi.dto.CoursesDTO;
import com.minden.exercise.mindenrestapi.entity.CourseRegistration;
import com.minden.exercise.mindenrestapi.entity.Student;
import com.minden.exercise.mindenrestapi.repository.CourseRegistrationRepository;
import com.minden.exercise.mindenrestapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private final CourseRegistrationRepository courseRegistrationRepository;

    public List<Student> getAllStudents(){
        return (List<Student>) studentRepository.findAll();
    }

    public List<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    @Autowired
    public StudentService(CourseRegistrationRepository courseRegistrationRepository) {
        this.courseRegistrationRepository = courseRegistrationRepository;
    }

    public List<CoursesDTO> getStudentCoursesById(Long studentId) {
        List<CourseRegistration> courses = courseRegistrationRepository.findByStudentId(studentId);
        return courses.stream()
                .map(courseRegistration -> new CoursesDTO(
                        courseRegistration.getId(),
                        courseRegistration.getCourse().getId(),
                        courseRegistration.getCourse().getCourseName(),
                        courseRegistration.getStatus(),
                        courseRegistration.getRegistrationDate()
                ))
                .collect(Collectors.toList());
    }
}
