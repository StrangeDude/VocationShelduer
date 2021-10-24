package ua.upc.vocationprojectpres.dao;

import ua.upc.vocationprojectpres.entity.StaffmovementEntity;
import ua.upc.vocationprojectpres.util.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;

public class StaffmovementDAOImpl implements StaffmovementDAO{


    @Override
    public StaffmovementEntity getStaffmovement(int id) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        return em.find(StaffmovementEntity.class ,id);
    }
}
