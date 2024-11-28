package java15.service.impl;

import java15.entity.House;
import java15.repo.HouseRepo;
import java15.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {
    private final HouseRepo houseRepo;

    @Override
    public void saveHouse(Long agencyId, House house) {
        houseRepo.saveHouse(agencyId, house);
    }

    @Override
    public List<House> getAllHouses() {
        return houseRepo.getAllHouses();
    }

    @Override
    public House getHouseById(Long id) {
        return houseRepo.getHouseById(id);
    }
}
