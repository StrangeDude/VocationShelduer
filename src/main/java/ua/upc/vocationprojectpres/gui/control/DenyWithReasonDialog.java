package ua.upc.vocationprojectpres.gui.control;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;

import java.io.IOException;

public class DenyWithReasonDialog extends Dialog<String> {

    private static final ButtonType denyButtonType = new ButtonType("Deny", ButtonBar.ButtonData.OK_DONE);

    public DenyWithReasonDialog() {
        setDefaultButtons();
        setContent();
        setDefaultInformation();

    }
    private void setDefaultInformation() {
        //Default login prompt information
        setHeaderText("Deny leave");
    }

    private void setDefaultButtons() {
        getDialogPane().getButtonTypes().setAll(denyButtonType, ButtonType.CANCEL);
    }

    private void setContent() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ua/upc/vocationprojectpres/view/dialog/deny-with-reason-dialog.fxml"));
        loader.setController(this);
        try {
            getDialogPane().setContent(loader.load());
        }catch (IOException ex) {ex.printStackTrace();}
    }

}
