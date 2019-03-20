package com.patryk.app;

/**
 * @author Patryk Kucharski
 *
 *
 * Represents board, and contains methods to display, initialize and put given marker
 *
 *
 */
public class Board extends BoardConfig {

    public Marker[][] board;

    public Board(int rows, int columns, int winningCondition){
        super(rows, columns, winningCondition);
        board = new Marker[super.rows][super.columns];
    }
}
