package org.student.service;

import org.student.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student save(Student student);

    List<Student> getAll();

    Optional<Student> getById(Long id);

    void deleteById(Long id);

    Student update(Student student);

}
