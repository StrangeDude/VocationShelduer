package ua.upc.vocationprojectpres.gui.controller;

import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.ProgressBarTableCell;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;
import ua.upc.vocationprojectpres.gui.control.DayColumn;
import ua.upc.vocationprojectpres.gui.view.EventBar;
import ua.upc.vocationprojectpres.model.MainModel;
import ua.upc.vocationprojectpres.model.User;
import ua.upc.vocationprojectpres.model.Vocation;
import ua.upc.vocationprojectpres.model.VocationStatus;

import java.time.LocalDate;

public class CalendarController implements MenuController {

    @FXML
    private Button prevMonthButton;

    @FXML
    private Button nextMonthButton;

    @FXML
    private Button todayButton;

    @FXML
    private TableColumn<User, String> usersColumn;

    @FXML
    private TableView<User> table;

    @FXML
    private TableColumn<User, User> monthColumn;

    private static final PseudoClass HOVERED_PSEUDO_CLASS = PseudoClass.getPseudoClass("hovered");


    private ObjectProperty<LocalDate> currentDate;

    private final ObservableList<DayColumn<User,User>> dayColumns = FXCollections.observableArrayList();


    @FXML
    public void initialize() {

        registerActions();
        setInformation();
        bindProperties();
        createDayColumns();
        updateDayColumns();
        registerListeners();

    }



    private void setInformation() {
        currentDate = new SimpleObjectProperty<>(LocalDate.now());



    }

    private void bindProperties() {
        monthColumn.textProperty().bind(Bindings.createStringBinding(() -> {
            final LocalDate date = currentDate.get();
            return date != null ? (date.getMonth() + " " + date.getYear()) : "";
        }, currentDate));
    }

    private MainModel model;

    @Override
    public void initModel(MainModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model;

        table.setItems(model.getSampleData());
        registerFactories();

    }


    private void registerFactories() {
        usersColumn.setCellValueFactory(data -> {
            User user = data.getValue();
            return user.nameProperty();
        });

        monthColumn.setCellValueFactory(data -> new SimpleObjectProperty<>(data.getValue()));



        for (DayColumn<User, User> dayColumn : dayColumns) {
            dayColumn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue()));

            dayColumn.setCellFactory(cell -> {
                TableCell<User, User> dayCell = new TableCell<>();
                /*dayCell.getStyleClass().add("day-cell");*/
                dayCell.itemProperty().addListener((obs, old, newVal) -> {
                    if (newVal != null) {
                        dayCell.graphicProperty().bind(Bindings.when(dayCell.emptyProperty()).then((StackPane) null).otherwise((StackPane) null));
                        LocalDate dayCellDate = currentDate.get().withDayOfMonth(dayColumn.getDay());

                        EventBar.Type barType;

                        for (Vocation vocation : newVal.getVocationList()) {
                            switch (vocation.getStatus()) {
                                case REQUESTED:
                                    barType = EventBar.Type.REQUESTED;
                                case APPROVED:
                                    barType = EventBar.Type.ASSIGNED;
                                case DENYED:
                                    barType = EventBar.Type.DENYED;
                                case CONFIRMED:
                                    barType = EventBar.Type.CONFIRMED;

                                    break;
                                default:
                                    throw new IllegalStateException("Unexpected value: " + vocation.getStatus());
                            }


                            if (dayCellDate.isEqual(vocation.getStartDate())) {
                                dayCell.pseudoClassStateChanged(HOVERED_PSEUDO_CLASS,true);
                                EventBar bar = new EventBar(EventBar.Segment.LEFT, barType);
                                dayCell.graphicProperty().bind(Bindings.when(dayCell.emptyProperty()).then((StackPane) null).otherwise(bar));
                            } else if (dayCellDate.isEqual(vocation.getEndDate())) {
                                dayCell.pseudoClassStateChanged(HOVERED_PSEUDO_CLASS,true);
                                EventBar bar = new EventBar(EventBar.Segment.RIGHT, barType);
                                dayCell.graphicProperty().bind(Bindings.when(dayCell.emptyProperty()).then((StackPane) null).otherwise(bar));
                            } else if((dayCellDate.isAfter(vocation.getStartDate()) &&
                                    dayCellDate.isBefore(vocation.getEndDate()))) {
                                dayCell.pseudoClassStateChanged(HOVERED_PSEUDO_CLASS,true);
                                EventBar bar = new EventBar(EventBar.Segment.MIDDLE, barType);
                                dayCell.graphicProperty().bind(Bindings.when(dayCell.emptyProperty()).then((StackPane) null).otherwise(bar));
                            } else {
                                dayCell.pseudoClassStateChanged(HOVERED_PSEUDO_CLASS,false);
                            }
                        }


                    }

                });
                return dayCell;
            });

        }
    }








    private void registerActions() {
        nextMonthButton.setOnAction(this::nextMonthButtonClicked);
        prevMonthButton.setOnAction(this::prevMonthButtonClicked);
        todayButton.setOnAction(this::todayButtonClicked);


    }

    private void registerListeners() {
        currentDate.addListener((obs, old, newVal) -> {
            if(newVal!= null) {
                updateDayColumns();
            }
        });

    }

    private void createDayColumns() {

        if(dayColumns.isEmpty()) {
            for (int day = 1; day <= 31 ; day++) {
                DayColumn<User, User> dayColumn = new DayColumn<>(day);
                dayColumns.add(dayColumn);
            }
        }

    }

    private void updateDayColumns() {
        if(!monthColumn.getColumns().isEmpty()) {
            monthColumn.getColumns().clear();
        }
        monthColumn.getColumns().addAll(dayColumns.subList(0,currentDate.get().lengthOfMonth()));
    }

    private void prevMonthButtonClicked(ActionEvent event) {
        currentDate.set(currentDate.get().minusMonths(1));
        table.requestLayout();
    }

    private void nextMonthButtonClicked(ActionEvent event) {
        currentDate.set(currentDate.get().plusMonths(1));
        table.requestLayout();
    }

    private void todayButtonClicked(ActionEvent event) {
        if(!currentDate.get().isEqual(LocalDate.now())) {
            currentDate.set(LocalDate.now());
        }
    }



}
