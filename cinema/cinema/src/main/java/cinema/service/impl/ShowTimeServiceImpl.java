package cinema.service.impl;

import cinema.entities.ShowTime;
import cinema.repository.ShowTimeRepo;
import cinema.service.ShowTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShowTimeServiceImpl implements ShowTimeService {
    private final ShowTimeRepo showTimeRepo;

    @Override
    public List<ShowTime> findAllShowTimes() {
        return showTimeRepo.findAllShowTimes();
    }

    @Override
    public void saveShowTime(ShowTime showTime) {

    }

    @Override
    public List<ShowTime> findShowTimesByCinemaAndMovie(Long cinemaId, Long movieId) {
        return showTimeRepo.findShowTimesByCinemaAndMovie(cinemaId, movieId);
    }
}
