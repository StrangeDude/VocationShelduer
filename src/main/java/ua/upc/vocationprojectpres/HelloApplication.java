package ua.upc.vocationprojectpres;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ua.upc.vocationprojectpres.entity.*;
import ua.upc.vocationprojectpres.gui.controller.HelloController;

import ua.upc.vocationprojectpres.service.StaffService;
import ua.upc.vocationprojectpres.service.UserService;
import ua.upc.vocationprojectpres.test.SideMenuItem;
import ua.upc.vocationprojectpres.test.TestModel;
import ua.upc.vocationprojectpres.test.User;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class HelloApplication extends Application {

    private Parent root;
    final static int WIDTH = 1000;
    final static int HEIGHT = 700;

    @Override
    public void init() throws Exception {
        setUserAgentStylesheet(STYLESHEET_MODENA);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ua/upc/vocationprojectpres/view/hello-view.fxml"));
        this.root = loader.load();
        HelloController helloController = loader.getController();
        TestModel model = new TestModel();
        model.loadTestData();
        model.readRequest();
        Map<String, SideMenuItem> items = loadMenuItems();
        model.setMenuItemMap(items);
        helloController.initModel(model);


        super.init();
    }

    @Override
    public void start(Stage stage) throws IOException, URISyntaxException {

        hibernateTest();
        long startTime = System.currentTimeMillis();
        stage.setMinWidth(WIDTH);
        stage.setMinHeight(HEIGHT);
        stage.setTitle("Hello!");
        stage.setScene(new Scene(root, WIDTH, HEIGHT));
        stage.show();

        //setUpApplication(stage);
        System.out.println("Start-up time: " + (System.currentTimeMillis() - startTime) + " ms");

    }


    private Map<String, SideMenuItem> loadMenuItems() throws URISyntaxException, IOException {
        Map<String, SideMenuItem> itemMap = new WeakHashMap<>();
        FXMLLoader loader;
        File filePath = new File(getClass().getResource("/ua/upc/vocationprojectpres/view/menu").toURI());
        File [] fileList = filePath.listFiles();
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


    private void hibernateTest() {

        StaffService staffService = new StaffService();
        StaffEntity staff = staffService.findStaff(1);
        Set<UserEntity> userEntitySet = staff.getUserEntitySet();
        for(UserEntity ent:userEntitySet) {
            System.out.println(ent.getName());
        }

    }

    public static void main(String[] args) {
        launch();
    }


}