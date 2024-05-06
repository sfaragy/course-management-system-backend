package com.minden.exercise.mindenrestapi.service;

import com.minden.exercise.mindenrestapi.entity.Student;
import com.minden.exercise.mindenrestapi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return (List<Student>) studentRepository.findAll();
    }
}
