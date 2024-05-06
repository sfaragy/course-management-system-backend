package com.minden.exercise.mindenrestapi.repository;

import com.minden.exercise.mindenrestapi.entity.CourseRegistration;
import com.minden.exercise.mindenrestapi.enums.StudentsCourseStatusEnum;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface CourseRegistrationRepository extends CrudRepository<CourseRegistration, Long>
{
    List<CourseRegistration> findByCourseId(Long course_id);
    List<CourseRegistration> findByStudentId(Long student_id);
    List<CourseRegistration> findByRegistrationDate(Date registration_date);
    List<CourseRegistration> findByStatus(StudentsCourseStatusEnum statusEnum);
}
