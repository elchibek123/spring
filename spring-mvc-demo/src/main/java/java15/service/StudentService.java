package java15.service;

import java15.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    void save(Student student);
}
