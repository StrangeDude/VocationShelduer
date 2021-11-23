package ua.upc.vocationprojectpres.gui.view;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.scene.layout.Region;

public class MonthChart extends Region {

    public enum Type {EVENT, DAY}

    public MonthChart(final Type type,MonthGrid grid) {

    }

    private ObjectProperty<Type> type;


    public void addEventBar(int cellIndex, EventBar bar) {

    }

    public void addDayCell(int cellIndex, DayCell dayCell) {

    }
}
