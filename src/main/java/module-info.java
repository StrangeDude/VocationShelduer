module ua.upc.vocationprojectpres {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires jdk.security.auth;


    exports ua.upc.vocationprojectpres;
    opens ua.upc.vocationprojectpres to java.persistence, org.hibernate.orm.core, javafx.fxml, java.base;
    opens view to javafx.fxml;
    exports ua.upc.vocationprojectpres.entity;
    opens ua.upc.vocationprojectpres.entity to javafx.fxml, org.hibernate.orm.core;
    exports ua.upc.vocationprojectpres.gui.controller;
    opens ua.upc.vocationprojectpres.gui.controller to javafx.fxml;
    exports ua.upc.vocationprojectpres.gui.control;
    opens ua.upc.vocationprojectpres.gui.control to javafx.fxml;
    exports ua.upc.vocationprojectpres.util;
    opens ua.upc.vocationprojectpres.util to java.persistence, org.hibernate.orm.core;
    exports ua.upc.vocationprojectpres.model;
    opens ua.upc.vocationprojectpres.model to javafx.fxml, javafx.base;

    exports ua.upc.vocationprojectpres.test;
    opens ua.upc.vocationprojectpres.test to javafx.fxml, javafx.base;
}