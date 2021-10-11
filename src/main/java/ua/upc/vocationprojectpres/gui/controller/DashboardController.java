package ua.upc.vocationprojectpres.gui.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.StageStyle;
import javafx.util.Pair;
import ua.upc.vocationprojectpres.gui.control.EditDialog;
import ua.upc.vocationprojectpres.gui.control.LoginDialog;
import ua.upc.vocationprojectpres.test.TestModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class DashboardController extends AbstractMenu{

    @FXML
    private VBox requestVBox;

    private TestModel model;

    private  List<HBox> requestBoxList;

    private ListIterator<HBox> hBoxIterator;

    private int counter = 1;


    public void initModel(TestModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model;
    }

    @FXML
    public void initialize() {
        requestBoxList = new ArrayList<>();
        System.out.println("DashboardController loaded");
        for(int i =0;i<10;i++) {
            HBox box = loadRquestView();
            requestBoxList.add(box);
        }
        hBoxIterator = requestBoxList.listIterator();
        System.out.println(requestBoxList.toString());
        requestVBox.getChildren().addAll(requestBoxList);}

    private HBox loadRquestView() {

        FXMLLoader loader = new FXMLLoader(getClass().
                getResource("/ua/upc/vocationprojectpres/view/menu/view-extension/dash-board-request-view.fxml"));
        try {
            loader.setController(new RequestController());
            HBox requestHBox =  loader.load();
            requestHBox.setId(requestHBox.getId()+counter);
            counter++;
            System.out.println("Request loaded");
            return requestHBox;
        } catch (IOException e) {
            System.out.println("Can't load request view");
            e.printStackTrace();
        }
        return null;
    }

    private void deleteRequest(ActionEvent event) {
        Node node  = (Node) event.getSource();
        Parent parent = node.getParent();
        parent.managedProperty().bind(parent.visibleProperty());
        parent.setVisible(false);
        this.requestVBox.getChildren().remove(node);

    }

    private HBox getRequestBox() {
        if (hBoxIterator.hasNext()) {
            return hBoxIterator.next();
        }
        return null;
    }

    private DashboardController getParrentInstance() {
        return this;
    }

    private class RequestController {
        @FXML
        Label requestReason;

        @FXML
        Button approveButton;

        @FXML
        Button denyButton;

        @FXML
        Button denyWithReasonButton;

        @FXML
        Button editButton;


        @FXML
        public void initialize() {
            System.out.println("RequestController loaded");
            setButtonsActions();

            requestReason.setText("test");
        }

        private void setButtonsActions() {
            this.approveButton.setOnAction(this::approveButtonClicked);
            this.denyButton.setOnAction(this::denyButtonClicked);
            this.denyWithReasonButton.setOnAction(this::denyWithReasonClicked);
            this.editButton.setOnAction(this::editButtonClicked);

        }

        private void approveButtonClicked (ActionEvent event) {
            System.out.println("Approved");
            deleteRequest(event);
        }

        private void denyButtonClicked (ActionEvent event) {
            System.out.println("Denyed");

        }

        private void denyWithReasonClicked (ActionEvent event) {
            System.out.println("Denyed with reason");
        }

        private void editButtonClicked (ActionEvent event) {
            System.out.println("Edit");
            String reason = "Test reason";
            EditDialog dialog = new EditDialog("test");
            dialog.initStyle(StageStyle.UTILITY);
            dialog.show();


        }


    }
}
