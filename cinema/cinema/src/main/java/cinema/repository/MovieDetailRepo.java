package cinema.repository;

import cinema.entities.MovieDetail;

public interface MovieDetailRepo {
    void saveMovieDetail(Long movieId, MovieDetail movieDetail);
}
