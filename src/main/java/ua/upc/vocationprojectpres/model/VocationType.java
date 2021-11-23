package ua.upc.vocationprojectpres.model;

import javafx.beans.property.*;
import ua.upc.vocationprojectpres.service.VocationTypeService;

import java.util.*;

public class VocationType{

    private final ReadOnlyStringProperty name;
    private final ReadOnlyIntegerProperty code;
    private static final Set<VocationType> VALUES = new HashSet<>();
    private static final Map<Integer, VocationType> MAP = new HashMap<>();


    static {
        List<VocationType> typeList = new VocationTypeService().getAllVocationTypes();
        if (typeList != null) {
            for (VocationType type: typeList) {
                MAP.put(type.getCode(),type);
            }
            VALUES.addAll(MAP.values());
        } else {
            throw new NullPointerException("Can not load type list from service!");
        }
    }


    public VocationType(String name, int code) {
        this.name = new SimpleStringProperty(name);
        this.code = new SimpleIntegerProperty(code);
    }

    public static Set<VocationType> values() {
        return VALUES;
    }

    public String getName() {
        return name.get();
    }

    public ReadOnlyStringProperty nameProperty() {
        return name;
    }

    public int getCode() {
        return code.get();
    }

    public ReadOnlyIntegerProperty codeProperty() {
        return code;
    }

    public static VocationType valueOf(Integer code){
        return MAP.get(code);
    }
    @Override
    public String toString() {
        return name.get();
    }
}
