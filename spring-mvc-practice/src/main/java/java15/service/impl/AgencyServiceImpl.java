package java15.service.impl;

import java15.entity.Agency;
import java15.repo.AgencyRepo;
import java15.service.AgencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AgencyServiceImpl implements AgencyService {
    private final AgencyRepo agencyRepo;

    @Override
    public void saveAgency(Agency agency) {
        agencyRepo.saveAgency(agency);
    }

    @Override
    public List<Agency> getAllAgencies() {
        return agencyRepo.getAllAgencies();
    }

    @Override
    public Agency getAgencyById(Long id) {
        return agencyRepo.getAgencyById(id);
    }

    @Override
    public void updateAgency(Long id, Agency newAgency) {
        agencyRepo.updateAgency(id, newAgency);
    }

    @Override
    public void deleteAgency(Long id) {
        agencyRepo.deleteAgency(id);
    }

    @Override
    public List<Agency> searchAgency(String word) {
        return agencyRepo.searchAgency(word);
    }
}
