package cinema.repository.impl;

import cinema.entities.Cinema;
import cinema.entities.Movie;
import cinema.exceptions.NotFoundException;
import cinema.repository.MovieRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MovieRepoImpl implements MovieRepo {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Movie> findAllMovies() {
        return entityManager.createQuery("select m from Movie m", Movie.class).getResultList();
    }

    @Override
    @Transactional
    public void saveMovie(Movie movie) {
        if (movie.getId() == null) {
            entityManager.persist(movie);
        } else {
            entityManager.merge(movie);
        }
    }

    @Override
    @Transactional
    public void assignCinemaToMovie(Long movieId, Long cinemaId) {
        Movie movie = findMovieById(movieId);
        Cinema cinema = entityManager.find(Cinema.class, cinemaId);
        if (movie != null && cinema != null) {
            movie.getCinemas().add(cinema);
            entityManager.merge(movie);
        }
    }

    @Override
    public Optional<Movie> findMovieWithShowTimesById(Long movieId) {
        String query = "SELECT m FROM Movie m " +
                "LEFT JOIN FETCH m.showTimes st " +
                "LEFT JOIN FETCH st.hall " +
                "WHERE m.id = :movieId";
        try {
            Movie movie = entityManager.createQuery(query, Movie.class)
                    .setParameter("movieId", movieId)
                    .getSingleResult();
            return Optional.of(movie);
        } catch (NotFoundException e) {
            return Optional.empty();
        }
    }

    @Override
    public Movie findMovieById(Long movieId) {
        return entityManager.find(Movie.class, movieId);
    }
}
