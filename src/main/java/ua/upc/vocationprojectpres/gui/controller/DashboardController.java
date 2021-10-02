package ua.upc.vocationprojectpres.gui.controller;

import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import ua.upc.vocationprojectpres.model.NewRequest;
import ua.upc.vocationprojectpres.model.Request;
import ua.upc.vocationprojectpres.model.TestModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class DashboardController extends AbstractMenu{

    private Request request;
    @FXML
    //private HBox requestBoxOne;
    //@FXML
    private HBox userInformationBoxOne;
    @FXML
    private HBox requestBoxTwo;

    @FXML
    private VBox requestVBox;

    private TestModel model;

    ObservableList<NewRequest> requestList;

    Iterator<NewRequest> requestIterator;




    public void initModel(TestModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model;
        requestList = model.getRequestList();
        requestIterator = requestList.iterator();
        prepareRequest();
        prepareRequest();
        prepareRequest();
        prepareRequest();
        prepareRequest();



    }

    private void prepareRequest() {
        if(requestList.iterator().hasNext()){
            buildRequest(requestIterator.next());
            requestIterator.remove();
        }
    }

    public void initialize() {
        System.out.println("dashboardControllerLoaded");

    }

    protected void buildRequest(NewRequest request) {
        FXMLLoader loader = new FXMLLoader();

        try {

            Node node = loader.load(Objects.requireNonNull(getClass().getResource("/ua/upc/vocationprojectpres/test/dash-board-request-view.fxml")).openStream());
            requestVBox.getChildren().add(node);
            DashboardRequestController requestController = loader.getController();
            requestController.setRequest(request);
            //get the controller
            //NodeTemplateController controller = (NodeTemplateController)loader.getController();
            //controller.setContent("Node number "+ counter++);
            /*requestVBox.getChildren().setAll((Node) FXMLLoader.
                    load((Objects.requireNonNull(getClass().
                            getResource("/ua/upc/vocationprojectpres/test/dash-board-request-view.fxml")))));*/
            //HBox testBox = new HBox();

            /*requestBoxTwo.getChildren().setAll((Node) FXMLLoader.
                    load(Objects.
                            requireNonNull(getClass().
                                    getResource("/ua/upc/vocationprojectpres/test/dash-board-request-view.fxml"))));*/
        } catch (Exception ex) {ex.printStackTrace();}
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void approveClick(ActionEvent event){
        System.out.println("approved");
        HBox approvedNode = (HBox)((Button)event.getSource()).getParent();
        deleteRequest(approvedNode);
        //if(requestIterator.hasNext()){prepareRequest();}

        //VBox parent = (VBox)approvedNode.getParent();
        //parent.getChildren().remove(approvedNode);
        //requestVBox.getChildren().remove(aprrovedNode);
        //requestVBox.getChildren().remove(aprrovedNode);
        //startRequestBoxAnimation(requestBoxOne, requestBoxTwo);
        //requestBoxOne = requestBoxTwo;
        //requestBoxTwo = new HBox();

    }

    public void deleteRequest(HBox requestBox){
        TranslateTransition translateRequestBoxOne = new TranslateTransition();
        translateRequestBoxOne.setByX(800);
        translateRequestBoxOne.setDuration(Duration.millis(500));
        translateRequestBoxOne.setCycleCount(1);
        translateRequestBoxOne.setNode(requestBox);
        translateRequestBoxOne.play();
        translateRequestBoxOne.setOnFinished(e -> {
            VBox parent = (VBox)requestBox.getParent();
            parent.getChildren().remove(requestBox);
        });




    }

    public HBox setRequestUserInformationView(HBox userInformationBox){
        ImageView imageView = new ImageView();
        Label userFirstAndLastName = new Label("First and last name");
        Label vocationType = new Label("Vocaiton type");
        Label userPostion = new Label("User position");
        userInformationBox.getChildren().addAll(imageView,userFirstAndLastName,vocationType,userPostion);
        userInformationBox.setMinWidth(370);
        userInformationBox.setPrefHeight(65);
        userInformationBox.setMaxHeight(65);
        userInformationBox.setMaxWidth(370);
        return userInformationBox;
    }


}
