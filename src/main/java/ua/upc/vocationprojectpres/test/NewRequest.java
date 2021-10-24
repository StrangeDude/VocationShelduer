package ua.upc.vocationprojectpres.test;

import java.util.Arrays;
import java.util.List;

public class NewRequest extends Request{

    public NewRequest(Vocation vocation, Person requester) {
        super(vocation, requester);
    }

    @Override
    public List<String> getRequestData() {
        return null;
    }


}
