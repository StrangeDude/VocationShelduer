package ua.upc.vocationprojectpres.test;

import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;
import ua.upc.vocationprojectpres.gui.controller.AbstractMenu;

import java.util.Objects;

public class SideMenuItem {

    private AnchorPane pane;
    private AbstractMenu controller;
    private String itemName;

    public SideMenuItem(String id) {
        //this constructor exist only to create root for submenus
        this.itemName = id;
    }
    public SideMenuItem(AbstractMenu controller, AnchorPane pane, String id){
        this.pane = pane;
        pane.setId(id);
        this.itemName = id;
        this.controller = controller;

    }

    public AnchorPane getPane() {
        return pane;
    }

    public AbstractMenu getController() {
        return controller;
    }

    public void setController(AbstractMenu controller) {
        this.controller = controller;
    }

    public String getItemName() {
        return itemName;
    }

    @Override
    public String toString() {
        return itemName;
    }


}
