package cinema.repository.impl;

import cinema.entities.ShowTime;
import cinema.repository.ShowTimeRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ShowTimeRepoImpl implements ShowTimeRepo {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<ShowTime> findAllShowTimes() {
        return entityManager.createQuery("select s from ShowTime s", ShowTime.class).getResultList();
    }

    @Override
    public void saveShowTime(ShowTime showTime) {

    }

    @Override
    public List<ShowTime> findShowTimesByCinemaAndMovie(Long cinemaId, Long movieId) {
        try {
            String jpql = """
                SELECT DISTINCT st FROM ShowTime st
                JOIN FETCH st.hall h
                JOIN FETCH st.movie m
                JOIN m.cinemas c
                WHERE c.id = :cinemaId
                AND m.id = :movieId
                ORDER BY st.startTime
                """;
            return entityManager.createQuery(jpql, ShowTime.class)
                    .setParameter("cinemaId", cinemaId)
                    .setParameter("movieId", movieId)
                    .getResultList();
        } catch (RuntimeException e) {
            throw new RuntimeException("Error fetching show times for cinema " + cinemaId + " and movie " + movieId, e);
        }
    }
}
