package ua.upc.vocationprojectpres.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;

import java.util.Collection;

public class Position {

    private final ReadOnlyStringProperty name;
    private final ReadOnlyStringProperty department;
    private final ObjectProperty<Position> chief;
    private final ObservableSet<User> UserSet = FXCollections.observableSet();

    public Position(String name, String department) {
        this.name = new SimpleStringProperty(name);
        this.department = new SimpleStringProperty(department);
        this.chief = new SimpleObjectProperty<>();
    }

    public ReadOnlyStringProperty departmentProperty() {
        return department;
    }

    public void setChief(Position chief) {
        this.chief.set(chief);
    }

    public Position getСhief() {
        return chief.get();
    }

    public ReadOnlyObjectProperty<Position> chiefProperty() {
        return chief;
    }

    public String getDepartment() {
        return department.get();
    }



    public String getName() {
        return name.get();
    }

    public ReadOnlyStringProperty nameProperty() {
        return name;
    }

    public ObservableSet<User> getUsers() {
        return UserSet;
    }




    public void addUser(User user) {
        UserSet.add(user);
    }

    public void setUsers(Collection<? extends User>  users) {
        UserSet.addAll(users);
    }


}
