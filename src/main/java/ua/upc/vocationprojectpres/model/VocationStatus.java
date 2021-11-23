package ua.upc.vocationprojectpres.model;

import java.util.HashMap;
import java.util.Map;

public enum VocationStatus {

    REQUESTED(1,"Розглядається"),
    DENYED(2,"Відмовлено"),
    APPROVED(3,"Розглянуто"),
    CONFIRMED(4,"Затвержено");

    private final int code;
    private final String name;
    private static final Map<Integer,VocationStatus> map = new HashMap<>();



    VocationStatus(int code, String name) {
        this.code = code;
        this.name = name;
    }

    static {
        for (VocationStatus vocationStatus : VocationStatus.values()) {
            map.put(vocationStatus.code,vocationStatus);
        }

    }

    public int getCode() {
        return this.code;
    }

    public static VocationStatus valueOf(int pageType) {
        return map.get(pageType);
    }

    public String getName() {
        return this.name;
    }


    @Override
    public String toString() {
        return this.name;
    }
}

