package org.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.course.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
