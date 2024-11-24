package cinema.service;

import cinema.entities.Cinema;
import cinema.entities.Hall;

import java.util.List;

public interface CinemaService {
    List<Cinema> findAllCinemas();

    void saveCinema(Cinema cinema);

    Cinema findCinemaById(Long cinemaId);

    void updateCinema(Long cinemaId, Cinema newCinema);

    void deleteCinema(Long cinemaId);
}
