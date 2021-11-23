package ua.upc.vocationprojectpres.dao;


import ua.upc.vocationprojectpres.entity.VocationTypeEntity;

import java.util.List;

public interface VocationTypeDAO {

    VocationTypeEntity getVocationType(int id);

    List<VocationTypeEntity> getAllVocationTypes();

    void createVocationRequest(VocationTypeEntity type);

    void updateVocationRequst(VocationTypeEntity type);

    void deleteVocationRequest(VocationTypeEntity type);
}
