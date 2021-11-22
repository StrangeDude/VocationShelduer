package ua.upc.vocationprojectpres.dao;

import ua.upc.vocationprojectpres.entity.StaffEntity;
import ua.upc.vocationprojectpres.util.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class StaffDAOImpl implements StaffDAO{


    @Override
    public StaffEntity getStaff(int id) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        return em.find(StaffEntity.class, id);
    }

    @Override
    public List<StaffEntity> getStaffList() {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        TypedQuery<StaffEntity> query = em.createQuery("SELECT s from StaffEntity s",StaffEntity.class);
        return query.getResultList();

    }

    @Override
    public StaffEntity getStaff() {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        TypedQuery<StaffEntity> query = em.createQuery("SELECT s from StaffEntity s",StaffEntity.class);
        return query.getSingleResult();
    }

    public List<StaffEntity> getStaffFromDepartment(String departmentName) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        TypedQuery<StaffEntity> query = em.createQuery(
                "SELECT s from StaffEntity s where s.department =: departmentName",StaffEntity.class
        ).setParameter("departmentName",departmentName);
        return query.getResultList();
    }
}
