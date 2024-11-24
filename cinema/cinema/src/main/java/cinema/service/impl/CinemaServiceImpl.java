package cinema.service.impl;

import cinema.entities.Cinema;
import cinema.entities.Hall;
import cinema.repository.CinemaRepo;
import cinema.service.CinemaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaServiceImpl implements CinemaService {
    private final CinemaRepo cinemaRepo;

    @Override
    public List<Cinema> findAllCinemas() {
        return cinemaRepo.findAllCinemas();
    }

    @Override
    public void saveCinema(Cinema cinema) {
        cinemaRepo.saveCinema(cinema);
    }

    @Override
    public Cinema findCinemaById(Long cinemaId) {
        return cinemaRepo.findCinemaById(cinemaId);
    }

    @Override
    public void updateCinema(Long cinemaId, Cinema newCinema) {
        cinemaRepo.updateCinema(cinemaId, newCinema);
    }

    @Override
    public void deleteCinema(Long cinemaId) {
        cinemaRepo.deleteCinema(cinemaId);
    }
}
