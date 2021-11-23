package ua.upc.vocationprojectpres.service;

import javafx.util.Pair;
import ua.upc.vocationprojectpres.dao.VocationDAO;
import ua.upc.vocationprojectpres.dao.VocationDAOImpl;
import ua.upc.vocationprojectpres.dao.VocationRequestDAO;
import ua.upc.vocationprojectpres.dao.VocationRequstDAOImpl;
import ua.upc.vocationprojectpres.entity.VocationEntity;
import ua.upc.vocationprojectpres.entity.VocationRequestEntity;
import ua.upc.vocationprojectpres.model.Department;
import ua.upc.vocationprojectpres.model.User;
import ua.upc.vocationprojectpres.model.Vocation;
import ua.upc.vocationprojectpres.model.VocationType;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VocationService {

    private static final VocationRequestDAO VOCATION_REQUEST_DAO = new VocationRequstDAOImpl();

    private static final VocationDAO VOCATION_DAO = new VocationDAOImpl();


    private static final Map<Integer, Pair<VocationRequestEntity, Vocation>> ENTITY_VOCATION_MAP = new HashMap<>();

    public static void createRequest(User user, LocalDate startDate, LocalDate endDate, VocationType type) {

    }

    public static void updateVocation() {
        //Approves, denyes, or edit Vocation

    }

    public static List<Vocation> getVocationList(User user) {
        //get user vocations
        return null;
    }

    public static List<Vocation> getDeprtmentVocation(Department department) {
        //get all vocations from department
        return null;
    }
/*
    private static void createModel(VocationRequestEntity requestEntity) {
        Vocation vocation = new Vocation(
                requestEntity.getId(),
                UserService.getUserModel(requestEntity.getUserEntity()),
                requestEntity.getStartDate().toLocalDate(),
                requestEntity.getEndDate().toLocalDate(),
                VocationType.valueOf(requestEntity.getVocationType())
        );
        if(!requestEntity.getReason().isEmpty()) {
            vocation.setReason(requestEntity.getReason());
        }
        ENTITY_VOCATION_MAP.put(requestEntity.getId(), new Pair<>(requestEntity, vocation));
    }



    private static void createEntity(Vocation vocation) {
        VocationRequestEntity entity = new VocationRequestEntity();
        entity.setUserEntity(UserService.getUserEntity(vocation.getUser()));
        entity.setStartDate(Date.valueOf(vocation.getStartDate()));
        entity.setEndDate(Date.valueOf(vocation.getEndDate()));
        entity.setStatus(vocation.getStatus().getCode());
        if(!vocation.getReason().isEmpty()){
            entity.setReason(vocation.getReason());
        }
        ENTITY_VOCATION_MAP.put(entity.getId(),new Pair<>(entity,vocation));
    }

    public VocationRequestEntity getVocationRequest(int id) {
        return VOCATION_REQUEST_DAO.getVocationRequest(id);
    }

    public void createVocationRequest(VocationRequestEntity vocationRequest) {
        VOCATION_REQUEST_DAO.createVocationRequest(vocationRequest);
    }

    public void updateVocatoinRequest(VocationRequestEntity vocationRequest) {
        VOCATION_REQUEST_DAO.updateVocationRequst(vocationRequest);
    }






    public VocationEntity findVocation(int id) {
        return VOCATION_DAO.getVocation(id);

    }

    public void createVocation(VocationEntity vocation) {
        VOCATION_DAO.createVocation(vocation);


    }*/
}
