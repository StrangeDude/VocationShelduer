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

    //Connections
    /*
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")

    protected UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
    */
    /*
    @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "POSITION_ID")
    private StaffEntity staff;

    public StaffEntity getStaff() {
        return staff;
    }

    public void setStaff(StaffEntity staff) {
        this.staff = staff;
    }
    */

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
