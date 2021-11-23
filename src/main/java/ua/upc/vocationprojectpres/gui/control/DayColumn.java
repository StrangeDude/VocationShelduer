package ua.upc.vocationprojectpres.gui.control;

import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.StackPane;
import ua.upc.vocationprojectpres.model.Vocation;

public class DayColumn<T, S> extends TableColumn<S,T> {

    private final ReadOnlyIntegerProperty day;

    public DayColumn(int day) {
        super(String.valueOf(day));
        this.day =  new SimpleIntegerProperty(day);
        setBehavior();
    }




    private void setBehavior() {
        setReorderable(false);
        setSortable(false);
        setResizable(false);
        setPrefWidth(25);
        setMaxWidth(5000);
    }

    private void registerListeners() {
    }


    public int getDay() {
        return day.get();
    }

    public ReadOnlyIntegerProperty dayProperty() {
        return day;
    }

    public StackPane createEventBar() {


        StackPane bar = new StackPane();
        bar.getStyleClass().add("event-bar");

        //switch ()
        //bar.setStyle("-fx-background-radius: 12");


        return bar;
    }


}
