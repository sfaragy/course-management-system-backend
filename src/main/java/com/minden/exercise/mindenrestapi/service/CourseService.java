package com.minden.exercise.mindenrestapi.service;

import com.minden.exercise.mindenrestapi.entity.Course;
import com.minden.exercise.mindenrestapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    public Course getCourseByName(String name) {
        List<Course> courses = courseRepository.findByCourseName(name);

        if (!courses.isEmpty()) {
            return courses.get(1);
        } else {
            return null;
        }
    }
}
