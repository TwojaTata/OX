package com.patryk.app.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Patryk Kucharski
 */
public class BoardConfig {

    public int rows;
    public int columns;
    public int winingConditionLength;
    public List<Player> players;

    public BoardConfig(){
    }

    BoardConfig(final int rows, final int columns, int winingCondition) {
        this.rows = rows;
        this.columns = columns;
        this.winingConditionLength = winingCondition;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardConfig that = (BoardConfig) o;
        return rows == that.rows &&
                columns == that.columns &&
                winingConditionLength == that.winingConditionLength &&
                Objects.equals(players, that.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rows, columns, winingConditionLength, players);
    }

}
