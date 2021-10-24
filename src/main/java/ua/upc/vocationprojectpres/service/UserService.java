package ua.upc.vocationprojectpres.service;

import ua.upc.vocationprojectpres.dao.UserDAO;
import ua.upc.vocationprojectpres.dao.UserDAOImpl;
import ua.upc.vocationprojectpres.entity.UserEntity;



public class UserService {

    private static UserDAO userDAO = new UserDAOImpl();

    public UserEntity getUser(int id) {
        return userDAO.getUser(id);
    }



}
