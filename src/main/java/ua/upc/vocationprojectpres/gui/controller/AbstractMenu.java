package ua.upc.vocationprojectpres.gui.controller;

import ua.upc.vocationprojectpres.test.TestModel;

public class AbstractMenu {
    private TestModel model;

    public void initModel(TestModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model;}
}
