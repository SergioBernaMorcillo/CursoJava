package org.course.service;

import org.course.entity.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {

    Course save(Course student);

    List<Course> getAll();

    Optional<Course> getById(Long id);

    void deleteById(Long id);

    Course update(Course student);

    void addStudent(Long idCourse, Long idStudent) throws Exception;
}
