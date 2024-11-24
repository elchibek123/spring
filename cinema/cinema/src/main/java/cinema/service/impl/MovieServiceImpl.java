package cinema.service.impl;

import cinema.entities.Movie;
import cinema.exceptions.NotFoundException;
import cinema.repository.MovieRepo;
import cinema.service.MovieService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepo movieRepo;

    @Override
    public List<Movie> findAllMovies() {
        return movieRepo.findAllMovies();
    }

    @Override
    public void saveMovie(Movie movie) {
        movieRepo.saveMovie(movie);
    }

    @Override
    public Movie findMovieById(Long movieId) {
        return movieRepo.findMovieById(movieId);
    }

    @Override
    @Transactional
    public void assignCinemaToMovie(Long movieId, Long cinemaId) {
        movieRepo.assignCinemaToMovie(movieId, cinemaId);
    }

    @Override
    public Movie findMovieWithShowTimesById(Long movieId) {
        return movieRepo.findMovieWithShowTimesById(movieId)
                .orElseThrow(() -> new NotFoundException("Movie not found with id: " + movieId));
    }
}
