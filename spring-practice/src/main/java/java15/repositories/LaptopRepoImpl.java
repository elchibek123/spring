package java15.repositories;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LaptopRepoImpl implements LaptopRepo, CrudRepo {
    @Autowired
    private final EntityManagerFactory entityManagerFactory;
}
