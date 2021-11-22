package ua.upc.vocationprojectpres.dao;

import ua.upc.vocationprojectpres.entity.UserEntity;

import java.util.List;

public interface UserDAO {

    UserEntity getUser(int id);

    List<UserEntity> getAllUsers();




}
