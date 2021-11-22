package ua.upc.vocationprojectpres.gui.control;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;

import javafx.util.Pair;

import java.io.IOException;

public class LoginDialog extends Dialog<Pair<String, String>> {

    public TextField usernameField;

    public PasswordField passwordField;

    public static ButtonType loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);

    public LoginDialog() {
        setDefaultInformation();
        setDefaultButtons();
        setContent();
        setBehaviour();
    }

    private void setDefaultInformation() {
        //Default login prompt information
        setTitle("Login");
        setHeaderText("Login");
    }

    private void setDefaultButtons() {
        getDialogPane().getButtonTypes().setAll(loginButtonType, ButtonType.CANCEL);
    }

    private void setContent() {
        //Create the content using FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/dialog/edit-dialog-view.fxml"));
        loader.setController(this);
        try {
            getDialogPane().setContent(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setBehaviour() {
        // If username and password have both been set, return values, else return null


        //Only enable login button when username and password have both been entered
        Node loginButton = getDialogPane().lookupButton(LoginDialog.loginButtonType);
        loginButton.disableProperty()
                .bind(Bindings.or(
                        usernameField.textProperty().isEmpty(),
                        passwordField.textProperty().isEmpty()
                ));
    }

}