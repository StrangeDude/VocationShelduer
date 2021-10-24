package ua.upc.vocationprojectpres.service;

import ua.upc.vocationprojectpres.dao.StaffDAO;
import ua.upc.vocationprojectpres.dao.StaffDAOImpl;
import ua.upc.vocationprojectpres.entity.StaffEntity;
import ua.upc.vocationprojectpres.entity.UserEntity;

public class StaffService {

    private static StaffDAO staffDAO = new StaffDAOImpl();

    public StaffEntity findStaff(int id) {
        return staffDAO.getStaff(id);
    }


}
