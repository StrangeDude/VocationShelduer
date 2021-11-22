package ua.upc.vocationprojectpres.gui.controller;


import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import ua.upc.vocationprojectpres.SideMenuItem;
import ua.upc.vocationprojectpres.model.MainModel;

import java.util.*;

public class HelloController implements MenuController {

    @FXML
    private TreeView<SideMenuItem> treeView;

    @FXML
    private AnchorPane contentPane;

    @FXML
    private Label nameLabel;

    @FXML

    private Label positionLabel;

    @FXML
    private Circle imageSpace;

    @FXML
    private BorderPane mainPane;

    private MainModel model;




    public void initModel(MainModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model;
        //System.out.println("model inited");
        treeViewInit(model.getMenuItemMap());

    }

    @FXML
    public void initialize() {
        System.out.println("HelloController loaded");


    }



    private void treeViewInit(Map<String, SideMenuItem> menuItems) {
        TreeItem<SideMenuItem> root = new TreeItem<>();


        SideMenuItem requsetLeaveMenu = menuItems.get("RequestLeaveView");
        SideMenuItem addLeaveMenu = menuItems.get("AddLeaveView");
        SideMenuItem dashboardMenu = menuItems.get("DashboardView");
        SideMenuItem calendarMenu = menuItems.get("CalendarView");
        SideMenuItem usersMenu = menuItems.get("UsersView");
        SideMenuItem generalSettingsMenu = menuItems.get("GeneralSettingsView");


        TreeItem<SideMenuItem> leaveRequestRoot = createMenuTreeItem(root, new SideMenuItem("LeaveRequestView"));
        createMenuTreeItem(leaveRequestRoot, requsetLeaveMenu);
        createMenuTreeItem(leaveRequestRoot, addLeaveMenu);
        createMenuTreeItem(root,dashboardMenu);
        createMenuTreeItem(root, usersMenu);
        createMenuTreeItem(root,calendarMenu);
        TreeItem<SideMenuItem> settingsRoot = createMenuTreeItem(root, new SideMenuItem("SettingsView"));
        createMenuTreeItem(settingsRoot, generalSettingsMenu);
        treeView.setShowRoot(false);
        treeView.setRoot(root);
        System.out.println(addLeaveMenu.toString());

        treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && !newValue.isLeaf()) {
                treeView.getSelectionModel().select(newValue.getChildren().get(0));
            }
            if (oldValue!= null
                    && oldValue.getParent() != newValue
                    && oldValue.getParent().getValue() != null
                    && oldValue.getParent().isExpanded()
                    && newValue.getParent() != oldValue.getParent()) { oldValue.getParent().setExpanded(false);}

            if (newValue != null && newValue.isLeaf()) {
                mainPane.setCenter(newValue.getValue().getPane());
            }
        });
    }

    private TreeItem<SideMenuItem> createMenuTreeItem(TreeItem<SideMenuItem> rootItem, SideMenuItem child) {
        TreeItem<SideMenuItem> childItem = new TreeItem<>(child);
        rootItem.getChildren().add(childItem);
        return childItem;
    }
}

