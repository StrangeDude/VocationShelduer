package ua.upc.vocationprojectpres.gui.controller;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import ua.upc.vocationprojectpres.test.Person;
import ua.upc.vocationprojectpres.test.SideMenuItem;
import ua.upc.vocationprojectpres.test.TestModel;

import java.util.*;

public class HelloController extends AbstractMenu {

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

    private TestModel model;

    public void initModel(TestModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model;
        System.out.println("model inited");
        treeViewInit();
        System.out.println(model.getMenuItemMap().toString());

    }

    @FXML
    public void initialize() {
        System.out.println("HelloController loaded");
        //treeViewInit();
        //System.out.println(model.getTestHello());
    }

    public void testTreeViewInit() {
        TreeItem<String> root = new TreeItem<>();
        //treeView.setRoot(root);
        List<TreeItem<String>> treeItemList = new ArrayList<>();
        TreeItem<String> itemOne = new TreeItem<>("Item one");
        TreeItem<String> subItemOne = new TreeItem<>("subItem one");

        itemOne.getChildren().add(subItemOne);
        treeItemList.add(itemOne);
        treeItemList.add(new TreeItem<>("test2"));
        ObservableList<TreeItem<String>> treeItems = FXCollections.observableList(treeItemList);
        root.getChildren().addAll(treeItems);
        treeView.setShowRoot(false);







    }

    public void treeViewInit() {
        Map<String, SideMenuItem> menuItems = model.getMenuItemMap();
        TreeItem<SideMenuItem> root = new TreeItem<>();


        SideMenuItem requsetLeaveMenu = menuItems.get("RequestLeaveView");
        SideMenuItem addLeaveMenu = menuItems.get("AddLeaveView");
        SideMenuItem dashboardMenu = menuItems.get("DashboardView");
        SideMenuItem calendarMenu = menuItems.get("UsersView");
        SideMenuItem generalSettingsMenu = menuItems.get("GeneralSettingsView");


        TreeItem<SideMenuItem> leaveRequestRoot = createMenuTreeItem(root, new SideMenuItem("Leave request"));
        createMenuTreeItem(leaveRequestRoot, requsetLeaveMenu);
        createMenuTreeItem(leaveRequestRoot, addLeaveMenu);
        createMenuTreeItem(root,dashboardMenu);
        createMenuTreeItem(root,calendarMenu);
        TreeItem<SideMenuItem> settingsRoot = createMenuTreeItem(root, new SideMenuItem("Settings"));
        createMenuTreeItem(settingsRoot, generalSettingsMenu);
        treeView.setShowRoot(false);
        treeView.setRoot(root);

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

            }
        });
    }

    private TreeItem<SideMenuItem> createMenuTreeItem(TreeItem<SideMenuItem> rootItem, SideMenuItem child) {
        TreeItem<SideMenuItem> childItem = new TreeItem<>(child);
        rootItem.getChildren().add(childItem);
        return childItem;
    }
}

