package org.course.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.course.entity.Course;
import org.course.service.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    @Autowired
    private CourseService service;

    @PostMapping(value = "/save")
    public Course save (@RequestBody Course course){
        return service.save(course);
    }

    @GetMapping (value = "/getAll")
    public List<Course> getAll (){
        return service.getAll();
    }

    @GetMapping(value = "/getById")
    public Optional<Course> getById(@RequestParam Long id) {
        return service.getById(id);
    }

    @DeleteMapping (value = "/deleteById")
    public ResponseEntity<Object> deleteById(@RequestParam Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping (value = "/update")
    public Course update (@RequestBody Course student){
        return service.update(student);
    }

    @PostMapping(value = "/addStudent")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity addStudent(@RequestBody AddStudentDto addStudentDto) {
        try {
            service.addStudent(addStudentDto.getCourseId(), addStudentDto.getStudentId());
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @Getter
    @Setter
    static class AddStudentDto {
        private Long courseId;
        private Long studentId;
    }
}
