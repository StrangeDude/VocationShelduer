package ua.upc.vocationprojectpres.service;

import ua.upc.vocationprojectpres.dao.UserDAO;
import ua.upc.vocationprojectpres.dao.UserDAOImpl;
import ua.upc.vocationprojectpres.entity.StaffEntity;
import ua.upc.vocationprojectpres.entity.UserEntity;
import ua.upc.vocationprojectpres.model.Position;
import ua.upc.vocationprojectpres.model.User;

import java.util.*;


public class UserService {

    private static final UserDAO USER_DAO = new UserDAOImpl();
    private static final Map<UserEntity, User> ENTITY_USER_MAP = new HashMap<>();
    private static final StaffService STAFF_SERVICE = new StaffService();
    private final List<User> users = new ArrayList<>();

    /*public UserService() {
        List<UserEntity> userEntities = USER_DAO.getAllUsers();
        for (UserEntity entity : userEntities) {
            users.add(createModel(entity));
        }
    }

    private User createModel(UserEntity entity) {

        return null;
    }

    public List<User> getUsers() {
        return users;
    }
*/
    public UserEntity getUser(int id) {
        return USER_DAO.getUser(1);
    }
}
