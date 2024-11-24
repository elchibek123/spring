package cinema.service;

import cinema.entities.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAllMovies();

    void saveMovie(Movie movie);

    Movie findMovieById(Long movieId);

    void assignCinemaToMovie(Long movieId, Long cinemaId);

    Movie findMovieWithShowTimesById(Long movieId);
}
