package ua.upc.vocationprojectpres.gui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import ua.upc.vocationprojectpres.model.User;

public class UsersController extends AbstractMenu {


    @FXML
    private AnchorPane UserView;

    @FXML
    private TableView<User> activeTableView;

    @FXML
    private TableColumn<User, String> activeNameColumn;

    @FXML
    private TableColumn<User, String> activeDepartamentColumn;

    @FXML
    private TableColumn<User, String> activeRoleColumn;

    @FXML
    private TableView<User> inactiveTableView;

    @FXML
    private TableColumn<User, String> inactiveNameColumn;

    @FXML
    private TableColumn<User, String> inactiveDepartamentColumn;

    @FXML
    private TableColumn<User, String> incativeRoleColumn;
    @FXML
    public void initialize() {
        System.out.println("UserController loaded");
        setActiveTableCellFactory();

    }

    private void setActiveTableCellFactory() {

    }



}
