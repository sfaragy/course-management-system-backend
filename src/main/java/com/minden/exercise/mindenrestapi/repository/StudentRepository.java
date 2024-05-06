package com.minden.exercise.mindenrestapi.repository;

import com.minden.exercise.mindenrestapi.entity.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findByStudentName(String studentName);

    List<Student> findByStudentEmail(String studentEmail);

    List<Student> findById(long id);
}
