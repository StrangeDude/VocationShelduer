package ua.upc.vocationprojectpres;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import ua.upc.vocationprojectpres.gui.controller.HelloController;
import ua.upc.vocationprojectpres.test.SideMenuItem;
import ua.upc.vocationprojectpres.test.TestModel;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException, URISyntaxException {
        Map<String, SideMenuItem> items = loadMenuItems();
        long startTime = System.currentTimeMillis();
        final int WIDTH = 1000;
        final int HEIGHT = 700;
        setUserAgentStylesheet(STYLESHEET_MODENA);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ua/upc/vocationprojectpres/view/hello-view.fxml"));
        Parent root = loader.load();
        HelloController helloController = loader.getController();
        TestModel model = new TestModel();
        model.loadTestData();
        model.readRequest();
        System.out.println(items.toString());
        model.setMenuItemMap(items);
        helloController.initModel(model);

        stage.setMinWidth(WIDTH);
        stage.setMinHeight(HEIGHT);
        stage.setTitle("Hello!");
        stage.setScene(new Scene(root, WIDTH, HEIGHT));
        stage.show();
        System.out.println("Start-up time: " + (System.currentTimeMillis() - startTime) + " ms");

    }

    private Map<String, SideMenuItem> loadMenuItems() throws URISyntaxException, IOException {
        Map<String, SideMenuItem> itemMap = new WeakHashMap<>();
        FXMLLoader loader;
        File filePath = new File(getClass().getResource("/ua/upc/vocationprojectpres/view/menu").toURI());
        File [] fileList = filePath.listFiles();
        for (File file: fileList) {
            System.out.println(file.getName());
        }
        assert fileList != null;
        for (File file : fileList) {
            if(file.isFile()) {
                loader = new FXMLLoader(file.toURI().toURL());
                SideMenuItem item = new SideMenuItem(loader.getController(), loader.load(),file.getName().
                        substring(0, file.getName().
                                lastIndexOf(".")));
                itemMap.put(item.getItemName(),item);
            }
        }
        return itemMap;
    }




    public static void main(String[] args) {
        launch();
    }


}