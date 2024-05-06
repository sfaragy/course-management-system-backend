package com.minden.exercise.mindenrestapi.init;

import com.minden.exercise.mindenrestapi.entity.Course;
import com.minden.exercise.mindenrestapi.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

/*
* This class will initialize 10 Courses in database during first migration.
*
* */
@Component
public class CourseDataInitializer implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void run(String... args) throws Exception {

        long numberOfCourses = courseRepository.count();
        if(numberOfCourses == 0){
            for (int i = 1; i <= 10; i++) {
                Date dateToday = new Date();
                Course course = new Course();
                course.setCourseName("Course " + i);
                course.setCredit(100 + i);
                course.setStatus(true);
                course.setDateCreated(dateToday);
                course.setDateUpdated(dateToday);

                courseRepository.save(course);
            }
        }
    }
}
