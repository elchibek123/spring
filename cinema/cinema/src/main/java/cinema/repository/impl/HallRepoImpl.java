package cinema.repository.impl;

import cinema.entities.Hall;
import cinema.repository.HallRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class HallRepoImpl implements HallRepo {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Hall> findHallsByCinemaId(Long cinemaId) {
        String hql = "SELECT DISTINCT h " +
                "FROM Hall h " +
                "JOIN h.showTimes st " +
                "JOIN st.movie m " +
                "JOIN m.cinemas c " +
                "WHERE c.id = :cinemaId";

        Query query = entityManager.createQuery(hql, Hall.class);
        query.setParameter("cinemaId", cinemaId);
        return query.getResultList();
    }
}
