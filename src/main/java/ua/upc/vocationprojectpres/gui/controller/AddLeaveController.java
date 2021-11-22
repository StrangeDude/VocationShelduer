package ua.upc.vocationprojectpres.gui.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import ua.upc.vocationprojectpres.model.User;
import ua.upc.vocationprojectpres.model.VocationType;
import ua.upc.vocationprojectpres.model.MainModel;
import ua.upc.vocationprojectpres.service.VocationService;

import java.time.LocalDate;

public class AddLeaveController implements MenuController {

    @FXML
    private AnchorPane LeaveRequestAnchorPane;

    @FXML
    private ChoiceBox<User> userChoiceBox;

    @FXML
    private ChoiceBox<VocationType> typeChoiceBox;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatePicker;

    @FXML
    private TextArea reasonTextArea;

    @FXML
    private Button createButton;

    private MainModel model;

    private User user;

    @FXML
    public void initialize() {

        setBehaviour();
        setDatePickersBehavior();
        //userChoiceBox.getItems().setAll(model.getUsers());
        typeChoiceBox.getItems().setAll(VocationType.values());
        System.out.println(typeChoiceBox.getItems().toString());


    }

    private void registerActions() {
        createButton.setOnAction(event -> {

        });
    }

    public void initModel(MainModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model;

        this.user = model.getUser();

        //userChoiceBox.getItems().setAll(user.getPosition());

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
                        or(userChoiceBox.valueProperty().isNull()).
                        or(typeChoiceBox.valueProperty().isNull())
                );
    }

}
