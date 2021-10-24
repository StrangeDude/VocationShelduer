package ua.upc.vocationprojectpres.model;

import ua.upc.vocationprojectpres.entity.VocationEntity;
import ua.upc.vocationprojectpres.entity.VocationRequestEntity;

public class Vocation {

    VocationRequestEntity entity;

    Vocation(VocationRequestEntity vocation) {
        this.entity = vocation;

    }

    public VocationRequestEntity getEntity() {
        return entity;
    }

    public void setEntity(VocationRequestEntity entity) {
        this.entity = entity;
    }
}
