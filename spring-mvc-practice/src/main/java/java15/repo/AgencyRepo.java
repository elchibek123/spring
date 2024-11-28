package java15.repo;

import java15.entity.Agency;

import java.util.List;

public interface AgencyRepo {
    void saveAgency(Agency agency);

    List<Agency> getAllAgencies();

    Agency getAgencyById(Long id);

    void updateAgency(Long id, Agency newAgency);

    void deleteAgency(Long id);

    List<Agency> searchAgency(String word);
}
