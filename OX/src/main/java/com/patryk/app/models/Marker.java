package com.patryk.app.models;

/**
 * @author Patryk Kucharski
 */
public enum Marker {

    CROSS("X"), CIRCLE("O"), BLANK("O");
    public String valueToDisplay;

    Marker(String valueToDisplay) {
        this.valueToDisplay = valueToDisplay;
    }
}
