package org.student.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.student.entity.Student;
import org.student.repository.StudentRepository;
import org.student.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    public List<Student> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Student> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Student update(Student student) {
        repository.save(student);
        return student;
    }
}
