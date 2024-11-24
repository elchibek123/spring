package cinema.repository;

import cinema.entities.Hall;

import java.util.List;

public interface HallRepo {
    List<Hall> findHallsByCinemaId(Long cinemaId);
}
