package ua.upc.vocationprojectpres;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import ua.upc.vocationprojectpres.gui.controller.MenuController;

import java.io.IOException;

public class SideMenuItem {


    private  final String itemName;
    private  MenuController controller;
    private Parent pane;


    public SideMenuItem(FXMLLoader loader, String id) throws IOException {
        this.pane = loader.load();
        this.controller = loader.getController();
        this.itemName = id;
    }
    public SideMenuItem(String id) {
        //this constructor exist only to create root for submenus
        this.itemName = id;
    }

    public MenuController getController() {
        return controller;
    }

    public Parent getPane() {
        return pane;
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
