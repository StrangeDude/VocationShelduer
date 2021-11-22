package ua.upc.vocationprojectpres;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import ua.upc.vocationprojectpres.gui.controller.HelloController;
import ua.upc.vocationprojectpres.model.MainModel;

import ua.upc.vocationprojectpres.model.User;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class HelloApplication extends Application {

    private Parent root;
    private final static int WIDTH = 1280;
    private final static int HEIGHT = 700;
    private final MainModel mainModel = new MainModel();


    @Override
    public void init() throws Exception {
        setUserAgentStylesheet(STYLESHEET_MODENA);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/hello-view.fxml"));
        this.root = loader.load();
        HelloController helloController = loader.getController();

        Map<String, SideMenuItem> items = loadMenuItems();
        items.values().forEach(item -> item.getController().initModel(mainModel));
        mainModel.setMenuItemMap(items);
        helloController.initModel(mainModel);

        super.init();
    }

    @Override
    public void start(Stage stage) throws IOException, URISyntaxException {
        com.sun.security.auth.module.NTSystem NTSystem = new com.sun.security.auth.module.NTSystem();
        long startTime = System.currentTimeMillis();
        stage.setMinWidth(WIDTH);
        stage.setMinHeight(HEIGHT);
        stage.setTitle("Hello!");
        stage.setScene(new Scene(root, WIDTH, HEIGHT));
        stage.show();

        System.out.println("Start-up time: " + (System.currentTimeMillis() - startTime) + " ms");

    }

    /*private void hibernateTest() {
        VocationService service = new VocationService();
        System.out.println(service.getVocationRequest(1).getStartDate());
    }*/


    private Map<String, SideMenuItem> loadMenuItems() throws URISyntaxException, IOException {
        Map<String, SideMenuItem> itemMap = new HashMap<>();
        FXMLLoader loader;
        File filePath = new File(getClass().getResource("/view/menu").toURI());
        File [] fileList = filePath.listFiles();
        assert fileList != null;
        for (File file : fileList) {
            if(file.isFile()) {
                loader = new FXMLLoader(file.toURI().toURL());
                SideMenuItem item = new SideMenuItem(loader, file.getName().
                        substring(0, file.getName().
                                lastIndexOf(".")));
                itemMap.put(item.getItemName(),item);
            }
        }
        return itemMap;
    }

    private User getTestUser() {
        // return UserService.getUser(1);
        return null;
    }

    public static void main(String[] args) {
        launch();
    }


}