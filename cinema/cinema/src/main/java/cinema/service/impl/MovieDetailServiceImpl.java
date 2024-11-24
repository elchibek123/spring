package cinema.service.impl;

import cinema.entities.MovieDetail;
import cinema.repository.MovieDetailRepo;
import cinema.service.MovieDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieDetailServiceImpl implements MovieDetailService {
    private final MovieDetailRepo movieDetailRepo;

    @Override
    public void saveMovieDetail(Long movieId, MovieDetail movieDetail) {
        movieDetailRepo.saveMovieDetail(movieId, movieDetail);
    }
}
