package cinema.service;

import cinema.entities.MovieDetail;

public interface MovieDetailService {
    void saveMovieDetail(Long movieId, MovieDetail movieDetail);
}
