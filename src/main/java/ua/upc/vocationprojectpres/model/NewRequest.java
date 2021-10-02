package ua.upc.vocationprojectpres.model;

import java.util.Arrays;
import java.util.List;

public class NewRequest extends Request{

    public NewRequest(Vocation vocation, Person requester) {
        super(vocation, requester);
    }

    public List<String> getRequestData() {
        Person person = this.getRequester();
        Vocation vocation = this.getVocation();
        List<String> requestData = Arrays.asList(
                person.getFirstName(),person.getSecondName(),person.getPosition(),person.getAvatar().getUrl(),
                vocation.getType(),vocation.getStartDate().toString(),vocation.getEndDate().toString(),vocation.getReason());
        return requestData;
    }
}
