package ua.upc.vocationprojectpres.gui.control;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.css.PseudoClass;
import javafx.scene.control.DateCell;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.ProgressBarTableCell;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;
import ua.upc.vocationprojectpres.gui.view.EventBar;
import ua.upc.vocationprojectpres.model.User;
import ua.upc.vocationprojectpres.model.Vocation;

import java.time.LocalDate;

public class DayTableCell<S> extends TableCell<S, LocalDate> {

    private final EventBar eventBar;

    private ObservableValue<User> observable;

    private static final PseudoClass HOVERED_PSEUDO_CLASS = PseudoClass.getPseudoClass("hovered");


    public DayTableCell() {
        this.getStyleClass().add("day-table-cell");
        this.eventBar = new EventBar();
        this.eventBar.setMaxWidth(Double.MAX_VALUE);
    }

    public static <S> Callback<TableColumn<S,LocalDate>, TableCell<S,LocalDate>> forTableColumn() {
        return param -> new DayTableCell<>();
    }

    @Override public void updateItem(LocalDate item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setGraphic(null);
        } else {

            DayColumn<S,User> dayColumn = (DayColumn<S,User>) getTableColumn();

        }






    }
}
