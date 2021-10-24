package ua.upc.vocationprojectpres.dao;

import ua.upc.vocationprojectpres.entity.VocationEntity;
import ua.upc.vocationprojectpres.util.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class VocationDAOImpl implements VocationDAO{
    @Override
    public VocationEntity getVocation(int id) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        return em.find(VocationEntity.class, id);
    }

    @Override
    public List<VocationEntity> getVocationList() {
        return null;
    }

    @Override
    public void createVocation(VocationEntity vocation) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(vocation);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateVocation(VocationEntity vocation) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(vocation);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void deleteVocation(VocationEntity vocation) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(vocation);
        em.getTransaction().commit();
        em.close();
    }
}
