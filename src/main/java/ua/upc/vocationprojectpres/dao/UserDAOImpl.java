package ua.upc.vocationprojectpres.dao;

import ua.upc.vocationprojectpres.entity.UserEntity;
import ua.upc.vocationprojectpres.util.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDAOImpl implements UserDAO{

    @Override
    public UserEntity getUser(int id) {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        return em.find(UserEntity.class,id);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        EntityManager em = EntityManagerFactoryUtil.getEntityManager();
        return (List<UserEntity>) em.
                createQuery("SELECT e FROM UserEntity e")
                .getResultList();
    }

}
