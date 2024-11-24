package cinema.service.impl;

import cinema.entities.Hall;
import cinema.repository.HallRepo;
import cinema.service.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HallServiceImpl implements HallService {
    private final HallRepo hallRepo;

    @Override
    public List<Hall> findHallsByCinemaId(Long cinemaId) {
        return hallRepo.findHallsByCinemaId(cinemaId);
    }
}
