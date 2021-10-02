module ua.upc.vocationprojectpres {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    exports ua.upc.vocationprojectpres.test;
    opens ua.upc.vocationprojectpres.test to javafx.fxml;
    exports ua.upc.vocationprojectpres.gui.controller;
    opens ua.upc.vocationprojectpres.gui.controller to javafx.fxml;


}