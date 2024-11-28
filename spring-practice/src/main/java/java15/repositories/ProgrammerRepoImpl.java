package java15.repositories;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProgrammerRepoImpl implements ProgrammerRepo, CrudRepo {
    @Autowired
    private final EntityManagerFactory entityManagerFactory;
}
