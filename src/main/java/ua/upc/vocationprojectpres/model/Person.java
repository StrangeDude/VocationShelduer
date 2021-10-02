package ua.upc.vocationprojectpres.model;

import javafx.beans.property.*;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class Person {

    private final StringProperty firstName = new SimpleStringProperty();
    private final StringProperty secondName = new SimpleStringProperty();
    private final StringProperty position = new SimpleStringProperty();
    private final Property<Image> avatar = new SimpleObjectProperty<>();

    public Person(String firstName, String secondName, String position) {
        setFirstName(firstName);
        setSecondName(secondName);
        setPosition(position);
        setAvatar(loadDefaultImage());
    }

    public Person(String firstName, String secondName, String position, Image image) {
        setFirstName(firstName);
        setSecondName(secondName);
        setPosition(position);
        setAvatar(image);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getSecondName() {
        return secondName.get();
    }

    public StringProperty secondNameProperty() {
        return secondName;
    }

    public String getPosition() {
        return position.get();
    }

    public StringProperty positionProperty() {
        return position;
    }

    public void setPosition(String position) {
        this.position.set(position);
    }

    public Image getAvatar() {
        return avatar.getValue();
    }

    public Property<Image> avatarProperty() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar.setValue(avatar);
    }

    public void setSecondName(String secondName) {
        this.secondName.set(secondName);
    }

    private Image loadDefaultImage() {
        try {
            return new Image("https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;

    }


}
