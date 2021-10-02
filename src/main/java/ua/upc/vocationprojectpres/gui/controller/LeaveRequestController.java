package ua.upc.vocationprojectpres.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import ua.upc.vocationprojectpres.model.NewRequest;
import ua.upc.vocationprojectpres.model.Request;
import ua.upc.vocationprojectpres.model.TestModel;
import ua.upc.vocationprojectpres.model.Vocation;
import ua.upc.vocationprojectpres.util.RequestWriter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

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

    }

    private LocalDate getStartDate() {
        LocalDate date = startDatePicker.getValue();
        return date;
    }

    private LocalDate getEndDate() {
        LocalDate date = endDatePicker.getValue();
        return date;
    }

    private String getReasonText() {
        return reasonText.getText();
    }

    public void createAction(ActionEvent event) throws IOException {
        //TODO validate date
        Vocation vocation = new Vocation(getStartDate(),getEndDate());
        if (getReasonText()!=null) vocation.setReason(getReasonText());
        System.out.println("Requester Name:" + this.model.getCurrentPerson().getFirstName());
        NewRequest request = new NewRequest(vocation,this.model.getCurrentPerson());
        this.model.setCurrentRequest(request);
        model.writeRequest();
        model.readRequest();
    }
}
