package org.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.student.entity.Student;
import org.student.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService service;

    // Constructor injection of the service
    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    // POST para crear nuevos estudiantes
    @PostMapping(value = "/save")
    public Student save(@RequestBody Student student) {
        return service.save(student);
    }

    // GET para obtener todos los estudiantes
    @GetMapping(value = "/getAll")
    public List<Student> getAll() {
        return service.getAll();
    }

    // GET para obtener un estudiante por ID
    @GetMapping(value = "/getById")
    public Optional<Student> getById(@RequestParam Long id) {
        return service.getById(id);
    }

    // DELETE para eliminar un estudiante por ID
    @DeleteMapping(value = "/deleteById")
    public ResponseEntity<Object> deleteById(@RequestParam Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // PUT para actualizar un estudiante
    @PutMapping(value = "/update")
    public Student update(@RequestBody Student student) {
        return service.update(student);
    }
}