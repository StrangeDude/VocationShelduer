package ua.upc.vocationprojectpres.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "VOCATION_REQUEST")
public class VocationRequestEntity {

    @Id
    private int id;

    @Column(name = "USER_ID")
    private int userId;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
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

    @Column(name = "APPROVE_DATE", nullable = false)
    private Date approveDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
}
