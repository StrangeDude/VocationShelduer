package ua.upc.vocationprojectpres.gui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import ua.upc.vocationprojectpres.test.TestModel;

public class LeaveRequestController extends AbstractMenu {

    @FXML
    DatePicker startDatePicker;
    @FXML
    DatePicker endDatePicker;
    @FXML
    TextArea reasonText;
    @FXML
    ChoiceBox<String> typeChoiseBox;

    private TestModel model;

    @Override
    public void initModel(TestModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model;
    }

    @FXML
    public void initialize() {
        System.out.println("LeaveReqquestController loaded");


    }

    public void testController() {
        System.out.println("Controller is accesible");
    }

}
