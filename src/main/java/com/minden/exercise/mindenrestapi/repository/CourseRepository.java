package com.minden.exercise.mindenrestapi.repository;

import com.minden.exercise.mindenrestapi.entity.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long>
{
    List<Course> findById(long id);

    List<Course> findByCourseName(String course_name);

    Long countById(long id);

}
