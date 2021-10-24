package ua.upc.vocationprojectpres.gui.control;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.util.Pair;
import ua.upc.vocationprojectpres.test.Request;

import java.io.IOException;

public class EditDialog extends  Dialog<Request> {

    @FXML
    public TextArea resonTextArea;


    
    private static final ButtonType editButtonType = new ButtonType("Edit leave", ButtonBar.ButtonData.OK_DONE);

    public  EditDialog() {
        setDefaultButtons();
        setContent();
        setDefaultInformation();

    }

    private void setDefaultInformation() {
        //Default login prompt information
        setHeaderText("Edit leave");
    }
    private void setDefaultButtons() {
        getDialogPane().getButtonTypes().setAll(editButtonType, ButtonType.CANCEL);
    }

    private void setContent() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ua/upc/vocationprojectpres/view/dialog/edit-dialog.fxml"));
        loader.setController(this);
        try {
            getDialogPane().setContent(loader.load());
        }catch (IOException ex) {ex.printStackTrace();}
    }

}
