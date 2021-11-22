package ua.upc.vocationprojectpres.entity;

import ua.upc.vocationprojectpres.model.User;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "STAFF")

public class StaffEntity implements Serializable {

    @Id
    private int id;

    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    /*
    @Basic
    @Column(name = "PARENT_ID", nullable = false)
    private int parentId;

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
    */
    @Basic
    @Column(name = "DIRECTION", nullable = true, length = 300)
    private String direction;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Basic
    @Column(name = "DEPARTMENT", nullable = true, length = 300)
    private String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Basic
    @Column(name = "UPC_POSITION", nullable = true, length = 300)
    private String upcPosition;

    public String getUpcPosition() {
        return upcPosition;
    }

    public void setUpcPosition(String upcPosition) {
        this.upcPosition = upcPosition;
    }

    @Basic
    @Column(name = "POSITION_CREATED", nullable = true)
    private Date positionCreated;

    public Date getPositionCreated() {
        return positionCreated;
    }

    public void setPositionCreated(Date positionCreated) {
        this.positionCreated = positionCreated;
    }

    @Basic
    @Column(name = "POSITION_CLOSED", nullable = true)
    private Date positionClosed;

    public Date getPositionClosed() {
        return positionClosed;
    }

    public void setPositionClosed(Date positionClosed) {
        this.positionClosed = positionClosed;
    }

    @Basic
    @Column(name = "HAY_LEVEL", nullable = true)
    private Short hayLevel;

    public Short getHayLevel() {
        return hayLevel;
    }

    public void setHayLevel(Short hayLevel) {
        this.hayLevel = hayLevel;
    }

    @Basic
    @Column(name = "CHEAF_POSITION", nullable = true)
    private Short cheafPosition;

    public Short getCheafPosition() {
        return cheafPosition;
    }

    public void setCheafPosition(Short cheafPosition) {
        this.cheafPosition = cheafPosition;
    }

    @Basic
    @Column(name = "COST_CENTER", nullable = true)
    private Short costCenter;

    public Short getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(Short costCenter) {
        this.costCenter = costCenter;
    }

    @Basic
    @Column(name = "EMP_JOB_TITLE", nullable = true, length = 255)
    private String empJobTitle;

    public String getEmpJobTitle() {
        return empJobTitle;
    }

    public void setEmpJobTitle(String empJobTitle) {
        this.empJobTitle = empJobTitle;
    }

    @Basic
    @Column(name = "EMP_BOARD_LEVEL", nullable = true, length = 10)
    private String empBoardLevel;

    public String getEmpBoardLevel() {
        return empBoardLevel;
    }

    public void setEmpBoardLevel(String empBoardLevel) {
        this.empBoardLevel = empBoardLevel;
    }

    @Basic
    @Column(name = "ORG_NAME", nullable = true, length = 255)
    private String orgName;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Basic
    @Column(name = "ORG_TYPE", nullable = true, length = 100)
    private String orgType;

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    @Basic
    @Column(name = "SHORT_POSITION", nullable = true, length = 100)
    private String shortPosition;

    public String getShortPosition() {
        return shortPosition;
    }

    public void setShortPosition(String shortPosition) {
        this.shortPosition = shortPosition;
    }



    //User
    //Staffmovement



    @OneToMany(mappedBy = "staff",fetch = FetchType.LAZY)
    private Set<UserEntity> userEntitySet;

    public Set<UserEntity> getUserEntitySet() {
        return userEntitySet;
    }

    public void setUserEntitySet(Set<UserEntity> userEntitySet) {
        this.userEntitySet = userEntitySet;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID",referencedColumnName = "ID")
    public StaffEntity parent;

    public StaffEntity getParent() {
        return parent;
    }

    public void setParent(StaffEntity parent) {
        this.parent = parent;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "PARENT_ID",referencedColumnName = "ID")
    public Set<StaffEntity> children;

    public Set<StaffEntity> getChilds() {
        return children;
    }

    public Set<StaffEntity> getAllChilds() {

            Set<StaffEntity> descendants = new HashSet<>();
            for (StaffEntity child : children) {
                if (!child.equals(child.getParent())) {
                    descendants.add(child);
                    descendants.addAll(child.getAllChilds());
                }
            }
            return descendants;

    }

    public void setChilds(Set<StaffEntity> childs) {
        this.children = childs;
    }
}
