package ua.upc.vocationprojectpres.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ua.upc.vocationprojectpres.SideMenuItem;
import ua.upc.vocationprojectpres.service.VocationService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainModel {

    private ObservableList<User> userList = FXCollections.observableArrayList();
    private final ObjectProperty<User> user = new SimpleObjectProperty<>();
    private Map<String, SideMenuItem> menuItemMap;
    private List<Vocation> vocationList = new ArrayList<>();
    private static final VocationService VOCATION_REQUEST_SERVICE = new VocationService();
    public void setMenuItemMap(Map<String, SideMenuItem> menuItemMap) {
        this.menuItemMap = menuItemMap;

    }

    public Map<String, SideMenuItem> getMenuItemMap() {
        return menuItemMap;
    }

    public User getUser() {
        return user.get();
    }

    public ObjectProperty<User> userProperty() {
        return user;
    }

    public void setUser(User user) {
        this.user.set(user);
    }

    public ObservableList<User> getChildUserList(User parent) {

        if(!userList.isEmpty()) { userList.clear();}
        return userList;
    }

    public List<Vocation> getVocationList() {

        return vocationList;
    }

    public void setVocationList(Set<Vocation> vocationList) {
    }

    public ObservableList<User> getSampleData() {

        User user = new User(
                1,
                "Test User",
                1,
                "test",
                "test",
                "test",
                "test"
        );

        Vocation test = new Vocation(
                2,
                user,
                LocalDate.now().minusDays(8),
                LocalDate.now().minusDays(2),
                VocationType.valueOf(2)
        );

        Vocation test1 = new Vocation(
                3,
                user,
                LocalDate.now(),
                LocalDate.now().plusDays(3),
                VocationType.valueOf(2)
        );
        Vocation test2 = new Vocation(
                4,
                user,
                LocalDate.now().minusDays(10),
                LocalDate.now().minusDays(3),
                VocationType.valueOf(2)
        );
        Vocation test3 = new Vocation(
                5,
                user,
                LocalDate.now().minusDays(12),
                LocalDate.now().minusDays(5).plusMonths(1),
                VocationType.valueOf(2)
        );

        user.addAllVocaitons(test,test1,test2,test3);

        ObservableList<User> users = FXCollections.observableArrayList();
        users.add(user);
        return users;
    }
}
