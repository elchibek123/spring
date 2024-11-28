package java15.service;

import java15.entity.Agency;

import java.util.List;

public interface AgencyService {
    void saveAgency(Agency agency);

    List<Agency> getAllAgencies();

    Agency getAgencyById(Long id);

    void updateAgency(Long id, Agency newAgency);

    void deleteAgency(Long id);

    List<Agency> searchAgency(String word);
}
