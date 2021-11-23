package ua.upc.vocationprojectpres.dao;


import ua.upc.vocationprojectpres.entity.VocationRequestEntity;

import java.util.List;

public interface VocationRequestDAO {

    VocationRequestEntity getVocationRequest(int id);

    List<VocationRequestEntity> getVocationRequestList(int approverId);

    void createVocationRequest(VocationRequestEntity vocation);

    void updateVocationRequst(VocationRequestEntity vocation);

    void deleteVocationRequest(VocationRequestEntity vocation);

}
