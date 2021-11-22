package ua.upc.vocationprojectpres.dao;

import ua.upc.vocationprojectpres.entity.StaffEntity;

import java.util.List;

public interface StaffDAO {

    StaffEntity getStaff(int id);

    StaffEntity getStaff();

    List<StaffEntity> getStaffList();

    List<StaffEntity> getStaffFromDepartment(String departmentName);

}
