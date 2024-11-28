package java15.repo.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java15.entity.Agency;
import java15.repo.AgencyRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class AgencyRepoImpl implements AgencyRepo {
    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public void saveAgency(Agency agency) {
        entityManager.persist(agency);
    }

    @Override
    public List<Agency> getAllAgencies() {
        return entityManager.createQuery("select a from Agency a", Agency.class).getResultList();
    }

    @Override
    public Agency getAgencyById(Long id) {
        try {
            return entityManager.createQuery("select a from Agency a where a.id = :id", Agency.class)
                    .setParameter("id", id).getSingleResult();
        } catch (NoResultException e) {
            throw new RuntimeException("Agency with ID: " + id + " not found." + e.getMessage());
        }
    }

    @Override
    public void updateAgency(Long id, Agency newAgency) {
        Agency agency = entityManager.find(Agency.class, id);
        if (agency == null) {
            throw new NoResultException("Agency with ID: " + id + " not found");
        }
        agency.setName(newAgency.getName());
        agency.setEmail(newAgency.getEmail());
        agency.setCountry(newAgency.getCountry());
        agency.setPhoneNumber(newAgency.getPhoneNumber());
        agency.setImageLink(newAgency.getImageLink());
    }

    @Override
    public void deleteAgency(Long id) {
        Agency agency = entityManager.find(Agency.class, id);
        entityManager.remove(agency);
    }

    @Override
    public List<Agency> searchAgency(String word) {
        return null;
    }
}
