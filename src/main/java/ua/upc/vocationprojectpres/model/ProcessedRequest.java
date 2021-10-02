package ua.upc.vocationprojectpres.model;

import java.util.Arrays;
import java.util.List;

public class ProcessedRequest extends Request{

    private Person approver;
    private String denyReason = "None";
    private Boolean status;

    public ProcessedRequest(Vocation vocation, Person requester, Person approver, Boolean status) {
        super(vocation, requester);
        this.approver = approver;
        this.status = status;
    }

    public String getDenyReason() {
        return denyReason;
    }

    public Person getApprover() {
        return approver;
    }

    public void setApprover(Person approver) {
        this.approver = approver;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setDenyReason(String denyReason) {
        this.denyReason = denyReason;
    }

    public List<String> getRequestData() {
        Person requester = this.getRequester();
        Person approver = this.getApprover();
        Vocation vocation = this.getVocation();
        List<String> requestData = Arrays.asList(
                requester.getFirstName(),requester.getSecondName(),requester.getPosition(),requester.getAvatar().getUrl(),
                vocation.getType(),vocation.getStartDate().toString(),vocation.getEndDate().toString(),vocation.getReason(),
                approver.getFirstName(),approver.getSecondName(),this.status.toString(),this.denyReason);
        return requestData;
    }
}
