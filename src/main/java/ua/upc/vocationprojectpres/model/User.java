package ua.upc.vocationprojectpres.model;

import javafx.beans.property.*;
import ua.upc.vocationprojectpres.entity.StaffEntity;
import ua.upc.vocationprojectpres.entity.UserEntity;

public class User {

    private final ReadOnlyStringProperty name;
    private final ReadOnlyIntegerProperty activeInUPC;
    private final ReadOnlyStringProperty login;
    private final ReadOnlyStringProperty email;
    private final ReadOnlyStringProperty intPhone;
    private final ReadOnlyStringProperty mobPhone;
    //private final ReadOnlyStringProperty position;
    //private final ReadOnlyStringProperty departament;

    public User(UserEntity user) {
        name = new SimpleStringProperty(user.getName());
        activeInUPC = new SimpleIntegerProperty(user.getActiveInUpc());
        login = new SimpleStringProperty(user.getUserLogin());
        email = new SimpleStringProperty(user.getUseremail());
        intPhone = new SimpleStringProperty(user.getIntphone());
        mobPhone = new SimpleStringProperty(user.getMobphone());

        //StaffEntity userStaff = user.getStaffmovement().getStaff();

        //position = new SimpleStringProperty(userStaff.getUpcPosition());
        //departament = new SimpleStringProperty(userStaff.getDepartment());
    }

    public String getName() {
        return name.get();
    }

    public ReadOnlyStringProperty nameProperty() {
        return name;
    }

    public int getActiveInUPC() {
        return activeInUPC.get();
    }

    public ReadOnlyIntegerProperty activeInUPCProperty() {
        return activeInUPC;
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

    /*public String getPosition() {
        return position.get();
    }

    public ReadOnlyStringProperty positionProperty() {
        return position;
    }

    public String getDepartament() {
        return departament.get();
    }

    public ReadOnlyStringProperty departamentProperty() {
        return departament;
    }

     */
}
