package com.patryk.app;

import java.util.List;

/**
 * @author Patryk Kucharski
 */
public class Board extends BoardConfig{

    Marker[][] board;

    Board(int rows, int columns, int winningCondition, List<Player> players){
        super(rows, columns, winningCondition, players);
        this.board = new Marker[super.rows][super.columns];
    }

}
