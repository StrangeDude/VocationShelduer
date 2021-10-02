package ua.upc.vocationprojectpres.gui.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import ua.upc.vocationprojectpres.model.*;
import ua.upc.vocationprojectpres.test.GUITestDrive;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Objects;

public class HelloController extends AbstractMenu {

    @FXML
    private TreeView<String> treeView;

    @FXML
    private AnchorPane contentPane;

    @FXML
    private Label nameLabel;

    @FXML

    private Label positionLabel;

    @FXML
    private Circle imageSpace;

    private TestModel model;

    public void initModel(TestModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model;
        setUpUser(model.getCurrentPerson());
        setUpTreeView();

    }





    public void initialize()  {}


    private void setUpTreeView() {

        TreeItem<String> root, dashboard, calendar, users, settings, leaveRequest;
        root = new TreeItem<>();

        leaveRequest = makeBranch("LeaveRequest",root);
        dashboard = makeBranch("Dashboard", root);
        calendar = makeBranch("Calendar", root);
        users = makeBranch("Users", root);
        settings = makeBranch("Settings", root);
        treeView.setShowRoot(false);
        treeView.setRoot(root);
        treeView.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) -> {
                    System.out.println(newValue.getValue() + "View.fxml");
                    //setLoadingDelay(4);
                    switchPanel(newValue.getValue());
        });
        treeView.getSelectionModel().select(dashboard);

    }

    private TreeItem<String>  makeBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }

    private void switchPanel(String viewName) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ua/upc/vocationprojectpres/test/" + viewName + "View.fxml"));
            Node node = loader.load();
            loader.getController();
            contentPane.getChildren().setAll(node);
            AbstractMenu  menuController = loader.getController();
            System.out.println(this.model.getCurrentPerson().getFirstName());
            menuController.initModel(this.model);
            /*contentPane.getChildren().setAll((Node)FXMLLoader.
                    load(Objects.
                            requireNonNull(getClass().
                                    getResource("/ua/upc/vocationprojectpres/test/" + viewName + "View.fxml"))));*/
            contentPane.setMinHeight(590);
            contentPane.setMinWidth(690);
        } catch (Exception ex) {ex.printStackTrace();}

    }

    private void setUpUser(Person person) {
        //TODO User login logic
        String fullCredentials = person.getFirstName() + " " + person.getSecondName();
        nameLabel.setText(fullCredentials);
        positionLabel.setText(person.getPosition());
        imageSpace.setFill(new ImagePattern(person.getAvatar()));
    }


}

