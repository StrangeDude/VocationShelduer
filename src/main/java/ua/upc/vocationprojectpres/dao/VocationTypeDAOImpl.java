package ua.upc.vocationprojectpres.dao;

import ua.upc.vocationprojectpres.entity.VocationTypeEntity;
import ua.upc.vocationprojectpres.util.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class VocationTypeDAOImpl implements VocationTypeDAO {

    @Override
    public VocationTypeEntity getVocationType(int id) {
        return null;
    }

    @Override
    public List<VocationTypeEntity> getAllVocationTypes() {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        TypedQuery<VocationTypeEntity> query = em.createQuery("select v from VocationTypeEntity v", VocationTypeEntity.class);
        return query.getResultList();
    }

    @Override
    public void createVocationRequest(VocationTypeEntity type) {

    }

    @Override
    public void updateVocationRequst(VocationTypeEntity type) {

    }

    @Override
    public void deleteVocationRequest(VocationTypeEntity type) {

    }
}
