package ua.upc.vocationprojectpres.service;


import ua.upc.vocationprojectpres.dao.VocationDAO;
import ua.upc.vocationprojectpres.dao.VocationDAOImpl;
import ua.upc.vocationprojectpres.entity.VocationEntity;

public class VocationService {

    VocationDAO vocationDAO = new VocationDAOImpl();

    public VocationEntity findVocation(int id) {
        return vocationDAO.getVocation(id);

    }

    public void createVocation(VocationEntity vocation) {
        vocationDAO.createVocation(vocation);


    }
}
