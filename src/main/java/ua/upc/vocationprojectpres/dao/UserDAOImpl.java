package ua.upc.vocationprojectpres.dao;

import ua.upc.vocationprojectpres.entity.UserEntity;
import ua.upc.vocationprojectpres.entity.VocationRequestEntity;
import ua.upc.vocationprojectpres.model.User;
import ua.upc.vocationprojectpres.util.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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
        TypedQuery<UserEntity> query = em.createQuery("select u from UserEntity u", UserEntity.class);
        return query.getResultList();
    }

}
