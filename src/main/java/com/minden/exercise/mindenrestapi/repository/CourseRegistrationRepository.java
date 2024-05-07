package com.minden.exercise.mindenrestapi.repository;

import com.minden.exercise.mindenrestapi.entity.CourseRegistration;
import com.minden.exercise.mindenrestapi.enums.StudentsCourseStatusEnum;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface CourseRegistrationRepository extends CrudRepository<CourseRegistration, Long>
{
    List<CourseRegistration> findByCourseId(Long course_id);
    List<CourseRegistration> findByStudentId(Long student_id);
    List<CourseRegistration> findByRegistrationDate(Date registration_date);
    List<CourseRegistration> findByStatus(StudentsCourseStatusEnum statusEnum);
    List<CourseRegistration> findByCourseIdAndStudentIdAndStatus(Long course_id, Long student_id, StudentsCourseStatusEnum statusEnum);

    @Query("SELECT cr.id FROM CourseRegistration cr WHERE cr.course.id = :courseId AND cr.student.id = :studentId AND cr.status = :status")
    List<Long> findIdsByCourseIdAndStudentIdAndStatus(Long courseId, Long studentId, StudentsCourseStatusEnum status);


    @Query("SELECT cr.student.id FROM CourseRegistration cr WHERE cr.course.id = :courseId AND cr.status = :status AND cr.student.id != :studentId")
    List<Long> findStudentIdsByCourseIdAndStatus(Long courseId, Long studentId, StudentsCourseStatusEnum status);
}
