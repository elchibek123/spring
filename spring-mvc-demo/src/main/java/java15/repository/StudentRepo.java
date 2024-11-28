package java15.repository;

import java15.entity.Student;

import java.util.List;

public interface StudentRepo {
    List<Student> findAll();

    void save(Student student);
}
