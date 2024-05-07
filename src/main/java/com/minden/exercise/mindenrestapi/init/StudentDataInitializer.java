package com.minden.exercise.mindenrestapi.init;

import com.minden.exercise.mindenrestapi.entity.Student;
import com.minden.exercise.mindenrestapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

/*
* This class will initialize 10 students in database during first migration.
*
*
* */

@Component
public class StudentDataInitializer implements CommandLineRunner
{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {

        long numberOfStudents = studentRepository.count();
        if (numberOfStudents == 0) {
            for (int i = 1; i <= 100; i++) {
                Date dateToday = new Date();
                Student student = new Student();
                student.setStudentEmail("student" + i + "@minden-rest-api.com");
                student.setStudentName("Student " + i);
                student.setStatus(1);
                student.setDateCreated(dateToday);
                student.setDateUpdated(dateToday);

                studentRepository.save(student);
            }
        }
    }
}
