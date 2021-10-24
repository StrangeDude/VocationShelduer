package ua.upc.vocationprojectpres.service;

import ua.upc.vocationprojectpres.dao.StaffDAO;
import ua.upc.vocationprojectpres.dao.StaffmovementDAO;
import ua.upc.vocationprojectpres.dao.StaffmovementDAOImpl;
import ua.upc.vocationprojectpres.entity.StaffmovementEntity;

public class StaffmovementService {
    private static StaffmovementDAO staffmovementDAO = new StaffmovementDAOImpl();

    public StaffmovementEntity getStaffmovement(int id) {
       return staffmovementDAO.getStaffmovement(id);
    }


}
