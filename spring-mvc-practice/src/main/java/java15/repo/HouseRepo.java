package java15.repo;

import java15.entity.House;

import java.util.List;

public interface HouseRepo {
    void saveHouse(Long agencyId,House house);

    List<House> getAllHouses();

    House getHouseById(Long id);
}
