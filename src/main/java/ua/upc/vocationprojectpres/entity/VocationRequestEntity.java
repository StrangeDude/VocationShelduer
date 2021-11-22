package ua.upc.vocationprojectpres.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "VOCATION_REQUEST")
public class VocationRequestEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @Column(name = "START_DATE",nullable = true)
    private Date startDate;

    @Column(name = "END_DATE",nullable = true)
    private Date endDate;

    @Column(name = "VOCATION_TYPE")
    private int vocationType;

    @Column(name = "STATUS")
    private int status;

    @Column(name = "APPROVER_ID")
    private int approverId;

    @Column(name = "REASON", length = 250)
    private String reason;

    @Column(name = "DENY_REASON", length = 250)
    private String denyReason;

    @Column(name = "APPROVE_DATE", nullable = true)
    private Date approveDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getVocationType() {
        return vocationType;
    }

    public void setVocationType(int vocationType) {
        this.vocationType = vocationType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getApproverId() {
        return approverId;
    }

    public void setApproverId(int approverId) {
        this.approverId = approverId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDenyReason() {
        return denyReason;
    }

    public void setDenyReason(String denyReason) {
        this.denyReason = denyReason;
    }

    public Date getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    UserEntity user;

    public UserEntity getUserEntity() {
        return user;
    }

    public void setUserEntity(UserEntity user) {
        this.user = user;
    }
}
