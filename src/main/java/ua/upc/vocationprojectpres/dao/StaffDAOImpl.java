package ua.upc.vocationprojectpres.dao;

import ua.upc.vocationprojectpres.entity.StaffEntity;
import ua.upc.vocationprojectpres.util.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;
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
        return  (List<StaffEntity>) em.
                createQuery("SELECT e FROM StaffEntity e")
                .getResultList();
    }
}
