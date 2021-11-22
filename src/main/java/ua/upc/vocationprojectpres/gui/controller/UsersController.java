package ua.upc.vocationprojectpres.gui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import ua.upc.vocationprojectpres.model.User;
import ua.upc.vocationprojectpres.model.MainModel;

public class UsersController implements MenuController {


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

    private MainModel model;


    @FXML
    public void initialize() {
        System.out.println("UserController loaded");
        setActiveTableCellFactory();

    }

    public void initModel(MainModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model;
    }

    private void setActiveTableCellFactory() {

    }



}
