package ua.upc.vocationprojectpres.gui.controller;


import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ua.upc.vocationprojectpres.gui.control.EditDialog;
import ua.upc.vocationprojectpres.model.*;

import java.io.IOException;
import java.util.List;

public class DashboardController implements MenuController {

    @FXML
    private VBox requestVBox;

    @FXML
    private VBox assignedVBox;


    private MainModel model;


    private List<Vocation> vocationList;


    @Override
    public void initModel(MainModel model)  {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model;




    }

    @FXML
    public void initialize() {
        System.out.println("DashboardController loaded");

    }



    private void loadRquest(Vocation vocation) {

        FXMLLoader loader = new FXMLLoader(getClass().
                getResource("/view/menu/view-extension/pending-requests.fxml"));
        try {
            RequestController requestController = new RequestController(vocation);
            loader.setController(requestController);
            HBox requestHBox =  loader.load();
            System.out.println("Request loaded");
            requestVBox.getChildren().add(requestHBox);
        } catch (IOException e) {
            System.out.println("Can't load request view");
            e.printStackTrace();
        }
    }




    void deleteRequest(ActionEvent event, Vocation vocation) {
        Parent parent = ((Node) event.getSource()).getParent();
        System.out.println(parent.getId());
        parent.managedProperty().bind(parent.visibleProperty());
        parent.setVisible(false);
        //TODO disapire animation
        this.requestVBox.getChildren();
    }

    private class RequestController {
        @FXML
        private HBox requestHBox;

        @FXML
        private HBox userInformationBox;

        @FXML
        private ImageView profileImage;

        @FXML
        private Label firstAndLastName;

        @FXML
        private Label vocationType;

        @FXML
        private Label requestReason;

        @FXML
        private Label startAndEndDate;

        @FXML
        private Button approveButton;

        @FXML
        private Button denyButton;

        @FXML
        private Button denyWithReasonButton;

        @FXML
        private Button editButton;

        private ObjectProperty<Vocation> vocation;


        private RequestController(Vocation vocation) {
            this.vocation = new SimpleObjectProperty<>(vocation);

        }

        private void setGraphic() {
            requestReason.managedProperty().bind(requestReason.visibleProperty());
            requestReason.visibleProperty().bind(vocation.get().reasonProperty().isEmpty().not());

        }



        private void setInformation() {
            if(vocation.get().reasonProperty()!=null){
                requestReason.textProperty().bind(vocation.get().reasonProperty());
            }
            firstAndLastName.textProperty().bind(vocation.get().getUser().nameProperty());
            vocationType.textProperty().bind(vocation.get().typeProperty().asString());
            startAndEndDate.textProperty().bind(Bindings.concat("From ",
                    vocation.get().startDateProperty().asString(), " to ", vocation.get().endDateProperty().asString()));




        }

        @FXML
        public void initialize() {
            registerActions();
            setInformation();
            setGraphic();
        }

        private void registerActions() {
            this.approveButton.setOnAction(this::approveButtonClicked);
            this.denyButton.setOnAction(this::denyButtonClicked);
            this.denyWithReasonButton.setOnAction(this::denyWithReasonClicked);
            this.editButton.setOnAction(this::editButtonClicked);

        }

        private void approveButtonClicked (ActionEvent event) {
            System.out.println("Approved");

            deleteRequest(event, this.vocation.get());
        }

        private void denyButtonClicked (ActionEvent event) {
            vocation.get().setStatus(VocationStatus.DENYED);
            deleteRequest(event, this.vocation.get());
        }

        private void denyWithReasonClicked (ActionEvent event) {
            createDenyDialog().showAndWait().ifPresent(reason -> {
                vocation.get().setDenyReason(reason);
                vocation.get().statusProperty().set(VocationStatus.DENYED);
                deleteRequest(event, vocation.get());
            });
        }

        private void editButtonClicked (ActionEvent event) {
            System.out.println("Edit");
            vocation.get().setType(VocationType.valueOf(1));
            EditDialog dialog = new EditDialog(vocation.get());
            dialog.showAndWait().ifPresent(editedVocation -> vocation.set(editedVocation));

        }

        private TextInputDialog createDenyDialog() {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Deny vocation");
            dialog.setHeaderText("Deny vocation");
            dialog.setContentText("Reason:");
            dialog.setGraphic(null);
            dialog.getDialogPane().setMinWidth(300);
            Node okButton = dialog.getDialogPane().lookupButton(ButtonType.OK);
            okButton.disableProperty().
                    bind(dialog.getEditor().textProperty().isEmpty());
            return dialog;
        }
    }


}
