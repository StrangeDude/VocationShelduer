package ua.upc.vocationprojectpres.service;

import ua.upc.vocationprojectpres.dao.VocationTypeDAO;
import ua.upc.vocationprojectpres.dao.VocationTypeDAOImpl;
import ua.upc.vocationprojectpres.entity.VocationTypeEntity;
import ua.upc.vocationprojectpres.model.VocationType;

import java.util.ArrayList;
import java.util.List;

public class VocationTypeService {

    private static final VocationTypeDAO vocationTypeDAO = new VocationTypeDAOImpl();

    public  List<VocationType> getAllVocationTypes() {
        List<VocationType> types = new ArrayList<>();
        vocationTypeDAO.getAllVocationTypes().
                forEach(entity -> types.add(
                        new VocationType(entity.getName(),entity.getId()))
                );
        return types;
    }
}
