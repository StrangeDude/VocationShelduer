package ua.upc.vocationprojectpres.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "USERS")
@SecondaryTable(name = "STAFFMOVEMENT",
        pkJoinColumns = {@PrimaryKeyJoinColumn(name = "USER_ID",referencedColumnName = "USER_ID")}
)
public class UserEntity implements Serializable {


    @Id
    @Column(name = "USER_ID", nullable = false)
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 300)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "ACTIVE_IN_UPC", nullable = false)
    private int activeInUpc;

    public int getActiveInUpc() {
        return activeInUpc;
    }

    public void setActiveInUpc(int activeInUpc) {
        this.activeInUpc = activeInUpc;
    }

    @Basic
    @Column(name = "HAY_LEVEL", nullable = true)

    private Integer hayLevel;

    public Integer getHayLevel() {
        return hayLevel;
    }

    public void setHayLevel(Integer hayLevel) {
        this.hayLevel = hayLevel;
    }

    @Basic
    @Column(name = "BIRTHDAY", nullable = true)
    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "HIRED", nullable = true)
    private Date hired;

    public Date getHired() {
        return hired;
    }

    public void setHired(Date hired) {
        this.hired = hired;
    }

    @Basic
    @Column(name = "FIRED", nullable = true)
    private Date fired;

    public Date getFired() {
        return fired;
    }

    public void setFired(Date fired) {
        this.fired = fired;
    }

    @Basic
    @Column(name = "BUSINESS", nullable = false)
    private int business;

    public int getBusiness() {
        return business;
    }

    public void setBusiness(int business) {
        this.business = business;
    }

    @Basic
    @Column(name = "INVALIDTYPE", nullable = true, precision = 0)
    private Integer invalidtype;

    public Integer getInvalidtype() {
        return invalidtype;
    }

    public void setInvalidtype(Integer invalidtype) {
        this.invalidtype = invalidtype;
    }

    @Basic
    @Column(name = "SEX", nullable = true, length = 1)
    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "USEREMAIL", nullable = true, length = 150)

    private String useremail;

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    @Basic
    @Column(name = "INTPHONE", nullable = true, length = 4)
    private String intphone;

    public String getIntphone() {
        return intphone;
    }

    public void setIntphone(String intphone) {
        this.intphone = intphone;
    }

    @Basic
    @Column(name = "MOBPHONE", nullable = true, length = 12)
    private String mobphone;

    public String getMobphone() {
        return mobphone;
    }

    public void setMobphone(String mobphone) {
        this.mobphone = mobphone;
    }

    @Basic
    @Column(name = "PA", nullable = true)
    private Short pa;

    public Short getPa() {
        return pa;
    }

    public void setPa(Short pa) {
        this.pa = pa;
    }

    @Basic
    @Column(name = "SALARY_NOTIFY", nullable = true)
    private Short salaryNotify;

    public Short getSalaryNotify() {
        return salaryNotify;
    }

    public void setSalaryNotify(Short salaryNotify) {
        this.salaryNotify = salaryNotify;
    }

    @Basic
    @Column(name = "USER_LOGIN", nullable = true, length = 20)
    private String userLogin;

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    @Basic
    @Column(name = "NAME_ENG", nullable = true, length = 300)
    private String nameEng;

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }

    @Basic
    @Column(name = "INSURANCE", nullable = true)
    private Integer insurance;

    public Integer getInsurance() {
        return insurance;
    }

    public void setInsurance(Integer insurance) {
        this.insurance = insurance;
    }

    @Basic
    @Column(name = "ENTREPRENEUR", nullable = true)
    private Short entrepreneur;

    public Short getEntrepreneur() {
        return entrepreneur;
    }

    public void setEntrepreneur(Short entrepreneur) {
        this.entrepreneur = entrepreneur;
    }

    @Basic
    @Column(name = "TAX_NUMBER", nullable = true, length = 10)
    private String taxNumber;

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    @Basic
    @Column(name = "EMP_GLOBAL_USERID", nullable = true, length = 100)
    private String empGlobalUserid;

    public String getEmpGlobalUserid() {
        return empGlobalUserid;
    }

    public void setEmpGlobalUserid(String empGlobalUserid) {
        this.empGlobalUserid = empGlobalUserid;
    }

    @Basic
    @Column(name = "LOCATION_ID", nullable = true, length = 64)
    private String locationId;

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }


    //connections

    //staffmovement 1
    /*
    @Column(table = "STAFFMOVEMENT", name = "POSITION_ID")
    private int positionId;

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }
    */
    @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(table = "STAFFMOVEMENT", name = "POSITION_ID")
    private StaffEntity staff;

    public StaffEntity getStaff() {
        return staff;
    }

    public void setStaff(StaffEntity staff) {
        this.staff = staff;
    }


    /*
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private StaffmovementEntity staffmovement;

    public StaffmovementEntity getStaffmovement() {
        return staffmovement;
    }

    public void setStaffmovement(StaffmovementEntity staffmovement) {
        this.staffmovement = staffmovement;
    }
    */

    //vocation 1

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private Set<VocationEntity> vocationSet;

    public Set<VocationEntity> getVocationSet() {
        return vocationSet;
    }

    public void setVocationSet(Set<VocationEntity> vocationSet) {
        this.vocationSet = vocationSet;
    }


    //GUI propertys




}
