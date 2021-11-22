package ua.upc.vocationprojectpres.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import ua.upc.vocationprojectpres.entity.StaffEntity;
import ua.upc.vocationprojectpres.entity.UserEntity;
import ua.upc.vocationprojectpres.service.UserService;

import java.util.HashSet;
import java.util.Set;

public class User {

    private final ReadOnlyIntegerProperty id;
    private final ReadOnlyStringProperty name;
    private final ReadOnlyStringProperty login;
    private final ReadOnlyStringProperty email;
    private final ReadOnlyStringProperty intPhone;
    private final ReadOnlyStringProperty mobPhone;
    private final ReadOnlyIntegerProperty acitvity;
    private final ObjectProperty<Position> position = new SimpleObjectProperty<>();
    private final ObservableList<Vocation> vocations = FXCollections.observableArrayList();

    public User(
                int id,
                String name,
                int activeInUPC,
                String login,
                String email,
                String intPhone,
                String mobPhone
                ) {
        this.id = new SimpleIntegerProperty(id);
        this.acitvity = new SimpleIntegerProperty(activeInUPC);
        this.name = new SimpleStringProperty(name);
        this.login = new SimpleStringProperty(login);
        this.email = new SimpleStringProperty(email);
        this.intPhone = new SimpleStringProperty(intPhone);
        this.mobPhone = new SimpleStringProperty(mobPhone);
    }


    public int getId() {
        return id.get();
    }

    public ReadOnlyIntegerProperty idProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public ReadOnlyStringProperty nameProperty() {
        return name;
    }

    public String getLogin() {
        return login.get();
    }

    public ReadOnlyStringProperty loginProperty() {
        return login;
    }

    public String getEmail() {
        return email.get();
    }

    public ReadOnlyStringProperty emailProperty() {
        return email;
    }

    public String getIntPhone() {
        return intPhone.get();
    }

    public ReadOnlyStringProperty intPhoneProperty() {
        return intPhone;
    }

    public String getMobPhone() {
        return mobPhone.get();
    }

    public ReadOnlyStringProperty mobPhoneProperty() {
        return mobPhone;
    }

    public int getAcitvity() {
        return acitvity.get();
    }

    public ReadOnlyIntegerProperty acitvityProperty() {
        return acitvity;
    }

    public Position getPosition() {
        return position.get();
    }

    public ObjectProperty<Position> positionProperty() {
        return position;
    }

    public void setPosition(Position position) {
        this.position.set(position);
    }

    public void addVocation(Vocation vocation) {
        vocations.add(vocation);
    }

    public void addAllVocaitons(Vocation... vocations) {
        this.vocations.addAll(vocations);
    }

    public ObservableList<Vocation> getVocationList() {
        return vocations;
    }

    @Override
    public String toString() {
        return this.name.get();
    }

}
