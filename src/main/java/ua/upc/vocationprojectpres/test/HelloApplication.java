package ua.upc.vocationprojectpres.test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ua.upc.vocationprojectpres.gui.controller.HelloController;
import ua.upc.vocationprojectpres.model.TestModel;

import java.io.FileReader;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        /* FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();*/
        final int WIDTH = 1000;
        final int HEIGHT = 700;
        setUserAgentStylesheet(STYLESHEET_MODENA);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ua/upc/vocationprojectpres/test/hello-view.fxml"));
        Parent root = loader.load();
        HelloController helloController = loader.getController();
        TestModel model = new TestModel();
        model.loadTestData();
        model.readRequest();
        helloController.initModel(model);

        stage.setMinWidth(WIDTH);
        stage.setMinHeight(HEIGHT);
        stage.setTitle("Hello!");
        stage.setScene(new Scene(root, WIDTH, HEIGHT));
        stage.show();




    }

    public static void main(String[] args) {
        launch();
    }
}