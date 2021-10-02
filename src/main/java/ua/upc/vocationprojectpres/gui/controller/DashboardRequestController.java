package ua.upc.vocationprojectpres.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import ua.upc.vocationprojectpres.model.NewRequest;
import ua.upc.vocationprojectpres.model.Request;

public class DashboardRequestController extends DashboardController {

    @FXML
    private ImageView profileImage;
    @FXML
    private Label vocationType;
    @FXML
    private Label firstAndLastName;
    @FXML
    private Label requestReason;
    @FXML
    private Label startAndEndDate;

    private NewRequest request;


    public NewRequest getRequest() {
        return request;
    }

    public void setRequest(NewRequest request) {
        this.request = request;
    }

    public void initialize() {
        System.out.println("DashboardRequestController loaded");
    }

    @Override
    public void approveClick(ActionEvent event){
        super.approveClick(event);
    }



    public void setVocationType(Label vocationType) {
        this.vocationType = vocationType;
    }

    public void setFirstAndLastName(Label firstAndLastName) {
        this.firstAndLastName = firstAndLastName;
    }

    public void setRequestReason(Label requestReason) {
        this.requestReason = requestReason;
    }

    public void setEndAndStartDate(Label endAndStartDate) {
        this.startAndEndDate = endAndStartDate;
    }

    public void buildRequest() {
        request = this.request;
        this.profileImage.setImage(request.getRequester().getAvatar());
        String startAndEndDate = "From " + request.getVocation().getStartDate().toString() + " to " +
                request.getVocation().getEndDate().toString();
        this.startAndEndDate.setText(startAndEndDate);
        String firstAndLastName = request.getRequester().getFirstName() + " " + request.getRequester().getSecondName();
        this.firstAndLastName.setText(firstAndLastName);
        if(request.getVocation().getReason()!=null) {
            this.requestReason.setText(request.getVocation().getReason());
        }

    }
}
