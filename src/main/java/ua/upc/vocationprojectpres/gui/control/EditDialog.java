package ua.upc.vocationprojectpres.gui.control;

import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import ua.upc.vocationprojectpres.model.Vocation;
import ua.upc.vocationprojectpres.model.VocationType;

import java.io.IOException;

public class EditDialog extends  Dialog<Vocation> {

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker endDatePicker;

    @FXML
    private ChoiceBox<VocationType> typeChoiseBox;

    @FXML
    private TextArea resonTextArea;

    private final BooleanProperty isChanged = new SimpleBooleanProperty(false);

    private final Vocation vocation;



    private static final ButtonType editButtonType = new ButtonType("Edit leave", ButtonBar.ButtonData.OK_DONE);

    public EditDialog(Vocation vocation) {
        this.vocation = vocation;
        setDefaultButtons();
        setContent();
        setDefaultInformation();
        //registerListiners();
        setBehaviour();
    }



    private void setDefaultInformation() {
        //Default login prompt information
        setHeaderText("Edit leave");
        typeChoiseBox.valueProperty().set(vocation.getType());
        typeChoiseBox.getItems().setAll(VocationType.values());
        startDatePicker.valueProperty().set(vocation.getStartDate());
        endDatePicker.valueProperty().set(vocation.getEndDate());
        resonTextArea.textProperty().set(vocation.getReason());

    }

    private void setDefaultButtons() {
        getDialogPane().getButtonTypes().setAll(editButtonType, ButtonType.CANCEL);
    }

    private void setContent() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/dialog/edit-dialog.fxml"));
        loader.setController(this);
        try {
            getDialogPane().setContent(loader.load());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void updateVocation(ActionEvent event) {
        vocation.setType(typeChoiseBox.getValue());
        vocation.setStartDate(startDatePicker.getValue());
        vocation.setEndDate(endDatePicker.getValue());
        if(resonTextArea.getText()!=null) {
            vocation.setReason(resonTextArea.getText());
        }
    }

    public void setBehaviour() {
        Button editButton = (Button) getDialogPane().lookupButton(EditDialog.editButtonType);
        editButton.disableProperty().bind(startDatePicker.valueProperty().isEqualTo(vocation.getStartDate()).
                and(endDatePicker.valueProperty().isEqualTo(vocation.getEndDate())).
                and(typeChoiseBox.valueProperty().isEqualTo(vocation.getType())).
                and(resonTextArea.textProperty().isEqualTo(vocation.getReason()))
        );
        editButton.setOnAction(this::updateVocation);
        setResultConverter(dialogButton -> editButton.isDisabled()  ? vocation : null);
    }
}