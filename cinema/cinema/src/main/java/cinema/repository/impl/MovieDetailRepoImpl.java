package cinema.repository.impl;

import cinema.entities.Movie;
import cinema.entities.MovieDetail;
import cinema.exceptions.NotFoundException;
import cinema.repository.MovieDetailRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MovieDetailRepoImpl implements MovieDetailRepo {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    @Transactional
    public void saveMovieDetail(Long movieId, MovieDetail movieDetail) {
        Movie movie = entityManager.find(Movie.class, movieId);
        if (movie == null) {
            throw new NotFoundException("Movie not found");
        }
        movie.setMovieDetail(movieDetail);
        entityManager.persist(movieDetail);
        movie.setMovieDetail(movieDetail);
        entityManager.merge(movie);
    }
}
