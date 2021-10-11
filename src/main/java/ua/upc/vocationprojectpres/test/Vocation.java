package ua.upc.vocationprojectpres.test;

import java.time.LocalDate;
import java.util.Date;

public class Vocation {

    private LocalDate startDate;
    private LocalDate endDate;
    private String reason = null;
    private String type = null;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public Vocation(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }



    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


}
