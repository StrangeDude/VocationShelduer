package ua.upc.vocationprojectpres.dao;

import ua.upc.vocationprojectpres.entity.VocationEntity;
import ua.upc.vocationprojectpres.entity.VocationRequestEntity;
import ua.upc.vocationprojectpres.util.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class VocationRequstDAOImpl implements VocationRequestDAO {
    @Override
    public VocationRequestEntity getVocationRequest(int id) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        return em.find(VocationRequestEntity.class, id);
    }

    @Override
    public List<VocationRequestEntity> getVocationRequestList(int approverId) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        TypedQuery<VocationRequestEntity> query = em.createQuery("select v from VocationRequestEntity v where v.approverId =: id", VocationRequestEntity.class).
                setParameter("id",approverId);
        return query.getResultList();
    }

    @Override
    public void createVocationRequest(VocationRequestEntity vocation) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(vocation);
        em.getTransaction().commit();
    }

    @Override
    public void updateVocationRequst(VocationRequestEntity vocation) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(vocation);
        em.getTransaction().commit();
    }

    @Override
    public void deleteVocationRequest(VocationRequestEntity vocation) {

    }
}
