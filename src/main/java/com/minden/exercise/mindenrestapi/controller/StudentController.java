package com.minden.exercise.mindenrestapi.controller;

import com.minden.exercise.mindenrestapi.entity.CourseRegistration;
import com.minden.exercise.mindenrestapi.entity.Student;
import com.minden.exercise.mindenrestapi.service.CourseRegistrationService;
import com.minden.exercise.mindenrestapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/minden-api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseRegistrationService courseRegistrationService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentService.getAllStudents();

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
        Optional<Student> studentOptional = studentService.getStudentById(studentId);
        return studentOptional
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{studentId}/courses")
    public ResponseEntity<List<CourseRegistration>> getStudentCoursesById(@PathVariable Long studentId) {
        List<CourseRegistration> studentCourses = studentService.getStudentCoursesById(studentId);
        return ResponseEntity.ok(studentCourses);
    }

    @DeleteMapping("/{studentId}/courses/{courseId}")
    public ResponseEntity<String> cancelCourseRegistration(@PathVariable Long studentId, @PathVariable Long courseId) {
        if(courseRegistrationService.deleteCourseRegistration(studentId, courseId)){
            return (ResponseEntity<String>) ResponseEntity.ok("Successfully cancel the course registration!");
        } else {
            return ResponseEntity.ok("Failed to cancel the course registration!");
        }

    }

    @GetMapping("/{studentId}/classmates/{courseId}")
    public ResponseEntity<List<Student>> getClassmatesByCourseId(@PathVariable Long studentId, @PathVariable Long courseId) {
        List<Student> students = courseRegistrationService.getClassmatesByCourseId(courseId, studentId);
        return ResponseEntity.ok(students);
    }


}
