package cinema.repository;

import cinema.entities.Cinema;
import cinema.entities.Hall;

import java.util.List;

public interface CinemaRepo {
    List<Cinema> findAllCinemas();

    List<Cinema> findAllById(Iterable<Long> ids);

    void saveCinema(Cinema cinema);

    Cinema findCinemaById(Long cinemaId);

    void updateCinema(Long cinemaId, Cinema newCinema);

    void deleteCinema(Long cinemaId);
}
