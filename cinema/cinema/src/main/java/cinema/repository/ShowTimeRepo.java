package cinema.repository;

import cinema.entities.ShowTime;

import java.util.List;

public interface ShowTimeRepo {
    List<ShowTime> findAllShowTimes();

    void saveShowTime(ShowTime showTime);

    List<ShowTime> findShowTimesByCinemaAndMovie(Long cinemaId, Long movieId);
}