package com.patryk.app;

/**
 * @author Patryk Kucharski
 */
public enum Marker {

    CROSS("X"), CIRCLE("O"), BLANK(" ");
    public String valueToDisplay;

    Marker(String valueToDisplay) {
        this.valueToDisplay = valueToDisplay;
    }
}
