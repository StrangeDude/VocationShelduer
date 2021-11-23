package ua.upc.vocationprojectpres.util;

import ua.upc.vocationprojectpres.dao.StaffDAOImpl;
import ua.upc.vocationprojectpres.entity.StaffEntity;
import ua.upc.vocationprojectpres.entity.UserEntity;
import ua.upc.vocationprojectpres.model.User;
import ua.upc.vocationprojectpres.service.StaffService;
import ua.upc.vocationprojectpres.service.UserService;

import java.util.HashSet;
import java.util.Set;

public class TestMain {

    public static void main(String[] args) {

        UserService userService = new UserService();
        UserEntity user = userService.getUser(1);
        StaffService staffService = new StaffService();
        StaffEntity staff = staffService.getStaff(0);
        TestMain main = new TestMain();
        staff.getAllChilds().forEach(child -> System.out.println(child.getUpcPosition()));

    }



}





