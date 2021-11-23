package ua.upc.vocationprojectpres.gui.view;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MonthGrid extends FlowPane {

    private List<StackPane> cells = new ArrayList();

    public MonthGrid(LocalDate date) {
        for (int i = 0; i < date.lengthOfMonth(); i++) {
            StackPane cell = new StackPane();
            cell.setPrefWidth(16.5);
            cell.setPrefHeight(15);
            cell.setStyle("-fx-border-color: black");
            cells.add(cell);
        }
        getChildren().setAll(cells);

    }


    public List<StackPane> getCells() {
        return cells;
    }


    private void combinateCells(int firstCellIndex, int lastCellIndex) {
        StackPane cell = new StackPane();
        StackPane firstCell = cells.get(firstCellIndex);
        StackPane lastCell = cells.get(lastCellIndex);
        double cellWidth = 0;
        for (int i = 0; i <= lastCellIndex-firstCellIndex; i++) {
            cellWidth = cellWidth + cells.get(i).getPrefWidth();
            cells.remove(i+1);
        }
        cell.setPrefWidth(cellWidth);
        cell.setStyle("-fx-border-color: black");
        cells.add(firstCellIndex,cell);
        getChildren().setAll(cells);
    }

    /*public void addEventBar(EventBar bar) {
        if(bar.getStartDay()!=bar.getEndDay()) {
            combinateCells(bar.getStartDay()-1, bar.getEndDay()-1);
            cells.get(bar.getStartDay()-1).getChildren().setAll(bar);

        }
    }*/
}
