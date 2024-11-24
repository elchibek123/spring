package cinema.repository.impl;

import cinema.entities.Cinema;
import cinema.entities.Hall;
import cinema.exceptions.NotFoundException;
import cinema.repository.CinemaRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CinemaRepoImpl implements CinemaRepo {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Cinema> findAllCinemas() {
        return entityManager.createQuery("select c from Cinema c", Cinema.class).getResultList();
    }

    @Override
    public List<Cinema> findAllById(Iterable<Long> ids) {
        return entityManager.createQuery(
                        "select c from Cinema c where c.id in :ids", Cinema.class)
                .setParameter("ids", ids)
                .getResultList();
    }

    @Override
    @Transactional
    public void saveCinema(Cinema cinema) {
        entityManager.persist(cinema);
    }

    @Override
    public Cinema findCinemaById(Long cinemaId) {
        return entityManager.find(Cinema.class, cinemaId);
    }

    @Override
    @Transactional
    public void updateCinema(Long cinemaId, Cinema newCinema) {
        Cinema cinema = entityManager.find(Cinema.class, cinemaId);
        if (cinema == null) {
            throw new NotFoundException("Cinema with ID " + cinemaId + " not found.");
        }
        cinema.setName(newCinema.getName());
        cinema.setImageLogo(newCinema.getImageLogo());
    }

    @Override
    @Transactional
    public void deleteCinema(Long cinemaId) {
        Cinema cinema = entityManager.find(Cinema.class, cinemaId);
        entityManager.remove(cinema);
    }
}
