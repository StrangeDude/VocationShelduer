package ua.upc.vocationprojectpres.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "VOCATION")

public class VocationEntity {


    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*
    @Basic
    @Column(name = "USER_ID", nullable = true)
    private Integer userId;
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    */
    @Basic
    @Column(name = "FROM_DATE", nullable = true)
    private Date fromDate;

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    @Basic
    @Column(name = "TO_DATE", nullable = true)
    private Date toDate;


    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    @Basic
    @Column(name = "HOLLIDAYS", nullable = true)
    private Short hollidays;

    public Short getHollidays() {
        return hollidays;
    }

    public void setHollidays(Short hollidays) {
        this.hollidays = hollidays;
    }

    @Basic
    @Column(name = "VOCATION_TYPE", nullable = true)
    private Integer vocationtype;
    public Integer getVocationtype() {
        return vocationtype;
    }

    public void setVocationtype(Integer vocationtype) {
        this.vocationtype = vocationtype;
    }

    @Basic
    @Column(name = "VOCATION_APPLICATION", nullable = true, length = 1)
    private String vocationApplication;
    public String getVocationApplication() {
        return vocationApplication;
    }

    public void setVocationApplication(String vocationApplication) {
        this.vocationApplication = vocationApplication;
    }

    @Basic
    @Column(name = "VOCATION_ORDER")
    private String vocationOrder;
    public String getVocationOrder() {
        return vocationOrder;
    }

    public void setVocationOrder(String vocationOrder) {
        this.vocationOrder = vocationOrder;
    }



    //Connections


    //User
    @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }


    //Propertys




}
