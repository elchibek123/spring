package java15.service;

import java15.entity.House;

import java.util.List;

public interface HouseService {
    void saveHouse(Long agencyId,House house);

    List<House> getAllHouses();

    House getHouseById(Long id);
}
