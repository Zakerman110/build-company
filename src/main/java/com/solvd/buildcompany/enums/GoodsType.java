package com.solvd.buildcompany.enums;

public enum GoodsType {

    MATERIAL("Material"),
    INSTRUMENT("Instrument");

    private final String value;

    GoodsType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
