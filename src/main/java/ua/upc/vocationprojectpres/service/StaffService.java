package ua.upc.vocationprojectpres.service;

import org.hibernate.hql.spi.PositionalParameterInformation;
import ua.upc.vocationprojectpres.dao.StaffDAO;
import ua.upc.vocationprojectpres.dao.StaffDAOImpl;
import ua.upc.vocationprojectpres.entity.StaffEntity;
import ua.upc.vocationprojectpres.entity.UserEntity;
import ua.upc.vocationprojectpres.model.Department;
import ua.upc.vocationprojectpres.model.Position;
import ua.upc.vocationprojectpres.model.User;

import java.util.*;

public class StaffService {

    private static final StaffDAO STAFF_DAO = new StaffDAOImpl();
    private static final Map<StaffEntity, Position> STAFF_ENTITY_POSITION_MAP = new HashMap<>();
    private static final Map<String, Department> DEPARTMENT_MAP = new HashMap<>();


    public StaffEntity getStaff(int id) {
        return STAFF_DAO.getStaff(id);
    }
/*
    public  Position getPositionModel(StaffEntity entity) {
        if(!DEPARTMENT_MAP.containsKey(entity.getDepartment())) {
            createDepartment(entity.getParent());
        }
        return STAFF_ENTITY_POSITION_MAP.get(entity);
    }

    public  Department getDepartment(StaffEntity entity) {
        if(!DEPARTMENT_MAP.containsKey(entity.getDepartment())) {
            createDepartment(entity.getParent());
        }
        return DEPARTMENT_MAP.get(entity.getDepartment());
    }

    private void createDepartment(StaffEntity parentEntity) {
        Department department = new Department(parentEntity.getDepartment());
        department.setParent(createPositionModel(parentEntity,department));
        Set<StaffEntity> childEntities = parentEntity.getChilds();
        for(StaffEntity child : childEntities) {
            if(!child.getChilds().isEmpty()&&!child.equals(parentEntity)) {
                department.addPostion(createPositionModel(child, department));
                createDepartment(child);
                department.addChild(getDepartment(child));
            } else {
                department.addPostion(createPositionModel(child,department));
            }
        }
        DEPARTMENT_MAP.put(department.getName(), department);
    }

    protected Position createPositionModel(StaffEntity entity, Department department){
        return null;
    }*/


}
