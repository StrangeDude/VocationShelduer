module ua.upc.vocationprojectpres {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.persistence;
    requires java.sql;

    exports ua.upc.vocationprojectpres;
    opens ua.upc.vocationprojectpres.view to javafx.fxml;
    exports ua.upc.vocationprojectpres.gui.controller;
    opens ua.upc.vocationprojectpres.gui.controller to javafx.fxml;
    exports ua.upc.vocationprojectpres.gui.control;
    opens ua.upc.vocationprojectpres.gui.control to javafx.fxml;


}