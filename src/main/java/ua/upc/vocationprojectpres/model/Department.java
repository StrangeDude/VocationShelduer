package ua.upc.vocationprojectpres.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Department {

    private final Set<Position> positions = new HashSet<>();
    private final ReadOnlyStringProperty name;
    private final ObjectProperty<Position> parent =  new SimpleObjectProperty<>();
    private final ObservableSet<Department> childs = FXCollections.observableSet();

    public Department(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public String getName() {
        return name.get();
    }

    public Position getParent() {
        return parent.get();
    }

    public ObjectProperty<Position> parentProperty() {
        return parent;
    }

    public void setParent(Position parent) {
        this.parent.set(parent);
    }

    public ReadOnlyStringProperty nameProperty() {
        return name;
    }

    public ObservableSet<Department> getChilds() {
        return childs;
    }



    public void addChild(Department child) {
        this.childs.add(child);
    }


    public Set<Position> getPositions() {
        return positions;
    }

    public void addPostion(Position position) {
        positions.add(position);
    }

    public List<User> getEmployees() {
        List<User> users = new ArrayList<>();
        positions.forEach(position -> {
            users.addAll(position.getUsers());
        });
        return users;
    }

    public List<User> getAllEmpolyees() {
        List<User> users = new ArrayList<>(getEmployees());
        if(!getChilds().isEmpty()) {
            for (Department child : getChilds()) {
                users.addAll(child.getAllEmpolyees());
            }
        }
        return users;
    }
}
