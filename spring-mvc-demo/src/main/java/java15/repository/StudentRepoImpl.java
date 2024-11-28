package java15.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java15.entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentRepoImpl implements StudentRepo {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("select s from Student s", Student.class).getResultList();
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }
}
