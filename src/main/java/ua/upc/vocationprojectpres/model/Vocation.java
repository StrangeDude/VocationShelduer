package ua.upc.vocationprojectpres.model;

import javafx.beans.binding.StringBinding;
import javafx.beans.property.*;
import ua.upc.vocationprojectpres.service.VocationService;

import java.time.LocalDate;
import java.util.Objects;

public class Vocation {

    private final ReadOnlyIntegerProperty id;
    private final ObjectProperty<LocalDate> startDate;
    private final ObjectProperty<LocalDate>  endDate;
    private final ObjectProperty<LocalDate> approveDate;
    private final ObjectProperty<VocationType> type;
    private final ObjectProperty<VocationStatus> status;
    private final ReadOnlyObjectProperty<User> user;
    private final ObjectProperty<User> approver;
    private final StringProperty reason;
    private final StringProperty denyReason;
    private static final VocationService SERVICE = new VocationService();


    public Vocation(int id, User user, LocalDate startDate, LocalDate endDate, VocationType type) {
        if(startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("Start date can not be after end date");
        }
        this.id = new SimpleIntegerProperty(id);
        this.user = new SimpleObjectProperty<>(user);
        this.startDate = new SimpleObjectProperty<>(startDate);
        this.endDate = new SimpleObjectProperty<>(endDate);
        this.approveDate  = new SimpleObjectProperty<>();
        this.type = new SimpleObjectProperty<>(type);
        this.status = new SimpleObjectProperty<>(VocationStatus.REQUESTED);
        this.reason = new SimpleStringProperty();
        this.denyReason = new SimpleStringProperty();
        this.approver = new SimpleObjectProperty<>();
    }

    public int getId() {
        return id.get();
    }

    public ReadOnlyIntegerProperty idProperty() {
        return id;
    }

    public void approve(User approver, LocalDate approveDate) {
        //setApproveDate(Date.valueOf(approveDate));
        this.approver.set(approver);
        this.approveDate.set(approveDate);
    }

    public void commitToDB() {
        //applyes changes to vocation
        //in ex. edit, approve etc..
    }





    public LocalDate getStartDate() {
        return startDate.get();
    }

    public ObjectProperty<LocalDate> startDateProperty() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate.set(startDate);
    }

    public LocalDate getEndDate() {
        return endDate.get();
    }

    public ObjectProperty<LocalDate> endDateProperty() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate.set(endDate);
    }

    public VocationType getType() {
        return type.get();
    }

    public ObjectProperty<VocationType> typeProperty() {
        return type;
    }

    public void setType(VocationType type) {
        this.type.set(type);
    }

    public VocationStatus getStatus() {
        return status.get();
    }

    public ObjectProperty<VocationStatus> statusProperty() {
        return status;
    }

    public void setStatus(VocationStatus status) {
        this.status.set(status);
    }

    public String getReason() {
        return reason.get();
    }

    public StringProperty reasonProperty() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason.set(reason);
    }

    public LocalDate getApproveDate() {
        return approveDate.get();
    }

    public ObjectProperty<LocalDate> approveDateProperty() {
        return approveDate;
    }

    public void setApproveDate(LocalDate approveDate) {
        this.approveDate.set(approveDate);
    }

    public String getDenyReason() {
        return denyReason.get();
    }

    public StringProperty denyReasonProperty() {
        return denyReason;
    }

    public void setDenyReason(String denyReason) {
        this.denyReason.set(denyReason);
    }

    public User getUser() {
        return user.get();
    }

    public ReadOnlyObjectProperty<User> userProperty() {
        return user;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vocation vocation = (Vocation) o;
        return  Objects.equals(startDate, vocation.startDate) && Objects.equals(endDate, vocation.endDate) && Objects.equals(approveDate, vocation.approveDate) && Objects.equals(type, vocation.type) && Objects.equals(status, vocation.status) && Objects.equals(user, vocation.user) && Objects.equals(reason, vocation.reason) && Objects.equals(denyReason, vocation.denyReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, endDate, approveDate, type, status, user, approver, reason, denyReason,
                startDate.get(),endDate.get(),approveDate.get(),type.get(),status.get(),user.get(),reason.get(),denyReason.get());
    }


}
