package ua.upc.vocationprojectpres.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "STAFFMOVEMENT")

public class StaffmovementEntity implements Serializable {

    @Id
    @Column(name = "ID", nullable = true)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "USER_ID", nullable = true)
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    @Basic
    @Column(name = "POSITION_ID", nullable = true)
    private Integer positionId;

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    @Basic
    @Column(name = "START_ON_POSITION", nullable = true)
    private Date startOnPosition;

    public Date getStartOnPosition() {
        return startOnPosition;
    }

    public void setStartOnPosition(Date startOnPosition) {
        this.startOnPosition = startOnPosition;
    }

    @Basic
    @Column(name = "FINISH_ON_POSITION", nullable = true)
    private Date finishOnPosition;

    public Date getFinishOnPosition() {
        return finishOnPosition;
    }

    public void setFinishOnPosition(Date finishOnPosition) {
        this.finishOnPosition = finishOnPosition;
    }

    @Column(name = "TEST_DATE")
    private Date testDate;

    public Date getTestDate() {
        return testDate;
    }

    public void setTestDate(Date testDate) {
        this.testDate = testDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffmovementEntity that = (StaffmovementEntity) o;
        return Objects.equals(id, that.id)  && Objects.equals(startOnPosition, that.startOnPosition) && Objects.equals(finishOnPosition, that.finishOnPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startOnPosition, finishOnPosition);
    }
}
