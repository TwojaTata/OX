package com.patryk.app;

/**
 * @author Patryk Kucharski
 *
 * represents marker, which board is made of
 * it's value is used to print state of a board
 */
public enum Marker {

    CROSS("X"), CIRCLE("O"), BLANK(" ");
    public String valueToDisplay;

    Marker(String valueToDisplay) {
        this.valueToDisplay = valueToDisplay;
    }
}
