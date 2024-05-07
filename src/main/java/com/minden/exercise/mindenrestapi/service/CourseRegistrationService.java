package com.minden.exercise.mindenrestapi.service;

import com.minden.exercise.mindenrestapi.dto.ClassmatesDTO;
import com.minden.exercise.mindenrestapi.dto.CourseRegistrationDto;
import com.minden.exercise.mindenrestapi.entity.Course;
import com.minden.exercise.mindenrestapi.entity.CourseRegistration;
import com.minden.exercise.mindenrestapi.entity.Student;
import com.minden.exercise.mindenrestapi.enums.StudentsCourseStatusEnum;
import com.minden.exercise.mindenrestapi.repository.CourseRepository;
import com.minden.exercise.mindenrestapi.repository.StudentRepository;
import com.minden.exercise.mindenrestapi.repository.CourseRegistrationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class CourseRegistrationService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRegistrationRepository courseRegistrationRepository;

    public CourseRegistration registerCourse(CourseRegistrationDto courseRegistrationData) {
        if (!getRegisteredCourse(courseRegistrationData.getCourseId(), courseRegistrationData.getStudentId())) {
            CourseRegistration courseRegistration = getCourseRegistrationEntity(courseRegistrationData);
            return courseRegistrationRepository.save(courseRegistration);
        } else {
            return null;
        }
    }

    private @NonNull CourseRegistration getCourseRegistrationEntity(CourseRegistrationDto courseRegistrationData) {
        Course course = this.getCourse(courseRegistrationData);
        Student student = getStudent(courseRegistrationData);
        StudentsCourseStatusEnum status = StudentsCourseStatusEnum.ACTIVE;
        Date currentDate = new Date();
        CourseRegistration courseRegistration = new CourseRegistration();
        courseRegistration.setCourse(course);
        courseRegistration.setStudent(student);
        courseRegistration.setStatus(status);
        courseRegistration.setRegistrationDate(currentDate);
        return courseRegistration;
    }

    private Student getStudent(@NonNull CourseRegistrationDto courseRegistrationData) {
        return studentRepository.findById(courseRegistrationData.getStudentId())
                .orElseThrow(() -> new EntityNotFoundException("Student not found"));
    }

    private Course getCourse(@NonNull CourseRegistrationDto courseRegistrationData) {
        return courseRepository.findById(courseRegistrationData.getCourseId())
                .orElseThrow(() -> new EntityNotFoundException("Course not found"));
    }


    private Boolean getRegisteredCourse(@NonNull Long courseId, @NonNull Long studentId) {
        List<CourseRegistration> registeredCourse = courseRegistrationRepository.findByCourseIdAndStudentIdAndStatus(
                courseId, studentId, StudentsCourseStatusEnum.ACTIVE
        );

        return !registeredCourse.isEmpty();
    }

    public Boolean deleteCourseRegistration(@NonNull Long studentId, @NonNull Long courseId) {
        List<Long> registeredCourseIds = courseRegistrationRepository.findIdsByCourseIdAndStudentIdAndStatus(
                courseId, studentId, StudentsCourseStatusEnum.ACTIVE
        );

        if (!registeredCourseIds.isEmpty()) {
            courseRegistrationRepository.deleteById(registeredCourseIds.get(0));
            return true;
        }

        return false;
    }

    public List<ClassmatesDTO> getClassmatesByCourseId(@NonNull Long courseId, @NonNull Long studentId) {
        List<Long> studentIds = courseRegistrationRepository.findStudentIdsByCourseIdAndStatus(
            courseId, studentId, StudentsCourseStatusEnum.ACTIVE
        );

        Iterable<Student> classmatesIterable = studentRepository.findAllById(studentIds);

        List<Student> classmates = new ArrayList<>();
        classmatesIterable.forEach(classmates::add);

        List<ClassmatesDTO> classmatesDTO = new ArrayList<>();
        for (Student student : classmates) {
            ClassmatesDTO studentDTO = new ClassmatesDTO(student.getId(), student.getStudentName(), student.getStudentEmail());
            classmatesDTO.add(studentDTO);
        }

        return classmatesDTO;
    }
}
