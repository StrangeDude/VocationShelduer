package ua.upc.vocationprojectpres.gui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import ua.upc.vocationprojectpres.model.MainModel;
import ua.upc.vocationprojectpres.model.Vocation;
import ua.upc.vocationprojectpres.model.VocationType;

import java.time.LocalDate;

public class LeaveRequestController implements MenuController {

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatePicker;

    @FXML
    private ChoiceBox<VocationType> typeChoiceBox;

    @FXML
    private TextArea reasonText;

    @FXML
    private Button createButton;

    private MainModel model;

    @Override
    public void initModel(MainModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model;
    }

    @FXML
    public void initialize() {
        System.out.println("LeaveReqquestController loaded");


    }

    private void registerActions() {

    }

    private void setDatePickersBehavior() {

        startDatePicker.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if(endDatePicker.getValue() == null) {
                    setDisable(empty || date.isBefore(LocalDate.now()));

                } else {
                    setDisable(empty || date.isAfter(endDatePicker.getValue().minusDays(1))
                            || date.isBefore(LocalDate.now()));

                }
            }
        });

        endDatePicker.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                if(startDatePicker.getValue() != null) {
                    setDisable(empty || date.isBefore(startDatePicker.getValue().plusDays(1)));
                } else {
                    setDisable(empty || date.isBefore(LocalDate.now().plusDays(1)));
                }
            }
        });
    }

    private void setBehaviour() {
        createButton.disableProperty()
                .bind(startDatePicker.valueProperty().isNull().
                        or(endDatePicker.valueProperty().isNull()).
                        or(typeChoiceBox.valueProperty().isNull())
                );
    }

}
