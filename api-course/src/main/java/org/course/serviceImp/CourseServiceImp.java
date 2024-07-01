package org.course.serviceImp;

import org.course.entity.CourseStudent;
import org.course.feign.StudentFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.course.entity.Course;
import org.course.repository.CourseRepository;
import org.course.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImp implements CourseService {

    @Autowired
    private StudentFeign studentFeign;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course save(Course student) {
        return courseRepository.save(student);
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> getById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }


    @Override
    public Course update(Course student) {
        courseRepository.save(student);
        return student;
    }

    public void addStudent(Long idCourse, Long idStudent) throws Exception {
        Optional<Course> optionalCourse = courseRepository.findById(idCourse);
        if (optionalCourse.isPresent()) {
            var result = studentFeign.getById(idStudent);
            if(result == null){
                throw new Exception("Student not found");
            }

            Course course = optionalCourse.get();
            CourseStudent courseStudent = new CourseStudent(course, idStudent);
            course.getCourseStudents().add(courseStudent);
            courseRepository.save(course);
        }else{
            throw new Exception("Course not found");
        }
    }
}
