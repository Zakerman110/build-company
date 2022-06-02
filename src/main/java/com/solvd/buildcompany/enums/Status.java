package com.solvd.buildcompany.enums;

public enum Status {

    PENDING("Pending"),
    CONFIRMED("Confirmed"),
    IN_PROGRESS("In progress"),
    COMPLETED("Completed"),
    CANCELED("Canceled");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
