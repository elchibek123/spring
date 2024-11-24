package cinema.service;

import cinema.entities.ShowTime;

import java.util.List;

public interface ShowTimeService {
    List<ShowTime> findAllShowTimes();

    void saveShowTime(ShowTime showTime);

    List<ShowTime> findShowTimesByCinemaAndMovie(Long cinemaId, Long movieId);
}
