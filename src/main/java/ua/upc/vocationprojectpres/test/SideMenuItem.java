package ua.upc.vocationprojectpres.test;

import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;
import ua.upc.vocationprojectpres.gui.controller.AbstractMenu;

import java.util.Locale;
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
        //TODO Must return menu item name without view
        String[] r = itemName.split("(?=\\p{Upper})");
        StringBuilder name = new StringBuilder();
        for (int i =0; i<r.length-1;i++) {
            if (i+1<r.length) {
                r[i+1] = r[i+1].toLowerCase();
            }
            name.append(" ").append(r[i]);
        }

        return name.toString();
    }


}
