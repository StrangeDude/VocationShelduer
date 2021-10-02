package ua.upc.vocationprojectpres.model;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;

import java.util.List;

public abstract class Request {

    private final Property<Person> requester = new SimpleObjectProperty<>();

    private final Property<Vocation> vocation = new SimpleObjectProperty<>();
            ;


    public Request(Vocation vocation, Person requester){
        setRequester(requester);
        setVocation(vocation);
    }
    public Person getRequester() {
        return requester.getValue();
    }

    public Property<Person> requesterProperty() {
        return requester;
    }

    public void setRequester(Person requester) {
        this.requester.setValue(requester);
    }

    public Vocation getVocation() {
        return vocation.getValue();
    }

    public Property<Vocation> vocationProperty() {
        return vocation;
    }

    public void setVocation(Vocation vocation) {
        this.vocation.setValue(vocation);
    }

    public abstract List<String> getRequestData();


}
