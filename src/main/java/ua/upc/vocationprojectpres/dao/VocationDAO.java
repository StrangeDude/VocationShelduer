package ua.upc.vocationprojectpres.dao;

import ua.upc.vocationprojectpres.entity.VocationEntity;

import java.util.List;

public interface VocationDAO  {

    VocationEntity getVocation(int id);

    List<VocationEntity> getVocationList();

    void createVocation(VocationEntity vocation);

    void updateVocation(VocationEntity vocation);

    void deleteVocation(VocationEntity vocation);



}
