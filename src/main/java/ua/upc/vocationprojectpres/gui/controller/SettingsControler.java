package ua.upc.vocationprojectpres.gui.controller;

import javafx.fxml.FXML;
import ua.upc.vocationprojectpres.model.MainModel;

public class SettingsControler implements MenuController {

    private MainModel model;


    @FXML
    public void initialize() {
        System.out.println("SettingsController loaded");
    }

    public void initModel(MainModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model;
    }
}
