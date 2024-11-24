package cinema.service;

import cinema.entities.Hall;

import java.util.List;

public interface HallService {
    List<Hall> findHallsByCinemaId(Long cinemaId);
}
