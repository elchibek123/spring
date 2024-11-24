package cinema.repository;

import cinema.entities.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieRepo {
    List<Movie> findAllMovies();

    void saveMovie(Movie movie);

    Movie findMovieById(Long movieId);

    void assignCinemaToMovie(Long movieId, Long cinemaId);

    Optional<Movie> findMovieWithShowTimesById(Long movieId);
}
