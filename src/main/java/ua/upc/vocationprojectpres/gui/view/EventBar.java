package ua.upc.vocationprojectpres.gui.view;

import javafx.beans.DefaultProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ObjectPropertyBase;
import javafx.css.PseudoClass;
import javafx.scene.layout.StackPane;

@DefaultProperty("children")

public class EventBar extends StackPane {

    public enum Type{
        REQUESTED,
        ASSIGNED,
        DENYED,
        CONFIRMED
    }

    public enum Segment {
        LEFT,
        MIDDLE,
        RIGHT
    }


    private final ObjectProperty<Type> type;

    private final ObjectProperty<Segment> segment;

    private static final PseudoClass REQUESTED_PSEUDO_CLASS = PseudoClass.getPseudoClass("requested");
    private static final PseudoClass ASSIGNED_PSEUDO_CLASS = PseudoClass.getPseudoClass("assigned");
    private static final PseudoClass DENYED_PSEUDO_CLASS = PseudoClass.getPseudoClass("denyed");
    private static final PseudoClass CONFIRMED_PSEUDO_CLASS = PseudoClass.getPseudoClass("confirmed");

    private static final PseudoClass LEFT_SEGMENT_PSEUDO_CLASS = PseudoClass.getPseudoClass("left");
    private static final PseudoClass MIDDLE_SEGMENT_PSEUDO_CLASS = PseudoClass.getPseudoClass("middle");
    private static final PseudoClass RIGHT_SEGMENT_PSEUDO_CLASS = PseudoClass.getPseudoClass("right");

    public EventBar() {
        this(Segment.MIDDLE,Type.REQUESTED);
    }

    public EventBar(final Segment segment, final Type type) {


        this.segment = new ObjectPropertyBase<>(segment) {
            @Override protected void invalidated() {
                switch(get()) {
                    case LEFT: {
                        pseudoClassStateChanged(LEFT_SEGMENT_PSEUDO_CLASS,true);
                        pseudoClassStateChanged(MIDDLE_SEGMENT_PSEUDO_CLASS,false);
                        pseudoClassStateChanged(RIGHT_SEGMENT_PSEUDO_CLASS,false);
                    }
                    case  MIDDLE: {
                        pseudoClassStateChanged(LEFT_SEGMENT_PSEUDO_CLASS,false);
                        pseudoClassStateChanged(MIDDLE_SEGMENT_PSEUDO_CLASS,true);
                        pseudoClassStateChanged(RIGHT_SEGMENT_PSEUDO_CLASS,false);
                    }
                    case RIGHT: {
                        pseudoClassStateChanged(LEFT_SEGMENT_PSEUDO_CLASS,false);
                        pseudoClassStateChanged(MIDDLE_SEGMENT_PSEUDO_CLASS,false);
                        pseudoClassStateChanged(RIGHT_SEGMENT_PSEUDO_CLASS,true);
                    }
                }
            }
            @Override public Object getBean() { return EventBar.this; }
            @Override public String getName() { return "segment"; }
        };

        this.type = new ObjectPropertyBase<>(type) {
            @Override protected void invalidated() {
                switch(get()) {
                    case REQUESTED: {
                        pseudoClassStateChanged(REQUESTED_PSEUDO_CLASS,true);
                        pseudoClassStateChanged(ASSIGNED_PSEUDO_CLASS,false);
                        pseudoClassStateChanged(DENYED_PSEUDO_CLASS,false);
                        pseudoClassStateChanged(CONFIRMED_PSEUDO_CLASS,false);
                    }
                    case  ASSIGNED: {
                        pseudoClassStateChanged(REQUESTED_PSEUDO_CLASS,false);
                        pseudoClassStateChanged(ASSIGNED_PSEUDO_CLASS,true);
                        pseudoClassStateChanged(DENYED_PSEUDO_CLASS,false);
                        pseudoClassStateChanged(CONFIRMED_PSEUDO_CLASS,false);
                    }

                    case DENYED: {
                        pseudoClassStateChanged(REQUESTED_PSEUDO_CLASS,false);
                        pseudoClassStateChanged(ASSIGNED_PSEUDO_CLASS,false);
                        pseudoClassStateChanged(DENYED_PSEUDO_CLASS,true);
                        pseudoClassStateChanged(CONFIRMED_PSEUDO_CLASS,false);
                    }

                    case CONFIRMED: {
                        pseudoClassStateChanged(REQUESTED_PSEUDO_CLASS,false);
                        pseudoClassStateChanged(ASSIGNED_PSEUDO_CLASS,false);
                        pseudoClassStateChanged(DENYED_PSEUDO_CLASS,false);
                        pseudoClassStateChanged(CONFIRMED_PSEUDO_CLASS,true);
                    }
                }
            }
            @Override public Object getBean() { return EventBar.this; }
            @Override public String getName() { return "type"; }
        };

        pseudoClassStateChanged(REQUESTED_PSEUDO_CLASS,    Type.REQUESTED    == type);
        pseudoClassStateChanged(ASSIGNED_PSEUDO_CLASS, Type.ASSIGNED == type);
        pseudoClassStateChanged(DENYED_PSEUDO_CLASS,     Type.DENYED     == type);
        pseudoClassStateChanged(CONFIRMED_PSEUDO_CLASS,     Type.CONFIRMED     == type);

        pseudoClassStateChanged(LEFT_SEGMENT_PSEUDO_CLASS,Segment.LEFT == segment);
        pseudoClassStateChanged(MIDDLE_SEGMENT_PSEUDO_CLASS,Segment.MIDDLE == segment);
        pseudoClassStateChanged(RIGHT_SEGMENT_PSEUDO_CLASS,Segment.RIGHT == segment);



        initGraphics();
    }


    private void initGraphics() {
        getStyleClass().add("event-bar");
    }



    public Type getType() {
        return type.get();
    }

    public ObjectProperty<Type> typeProperty() {
        return type;
    }

    public Segment getSegment() {
        return segment.get();
    }

    public ObjectProperty<Segment> segmentProperty() {
        return segment;
    }
}
