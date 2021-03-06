package com.patryk.app;

import java.util.Objects;

/**
 * @author Patryk Kucharski
 *
 * player representation
 */
public class Player {

    private String name;
    private boolean hasTurn;
    private Marker marker;

    public Player(String name, boolean hasTurn, Marker marker) {
        this.name = name;
        this.hasTurn = hasTurn;
        this.marker = marker;
    }

    public Marker getMarker() {
        return marker;
    }

    public boolean hasTurn() {
        return hasTurn;
    }

    public void setTurn(boolean hasTurn) {
        this.hasTurn = hasTurn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return hasTurn == player.hasTurn &&
                Objects.equals(name, player.name) &&
                marker == player.marker;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hasTurn, marker);
    }

    @Override
    public String toString() {
        return "Current Player: " + name + " Marker: " + marker.valueToDisplay;
    }

    public String getName() {
        return this.name;
    }
}
