package com.patryk.app;

import java.util.List;

/**
 * @author Patryk Kucharski
 */
public class Board extends BoardConfig{

    Marker[][] board;

    Board(int rows, int columns, int winningCondition){
        super(rows, columns, winningCondition);
        this.board = new Marker[super.rows][super.columns];
    }

    public void fillBoardWithBlanks(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = Marker.BLANK;
            }
        }
    }

    public void putMarker(int row, int column, Marker marker) {
        board[row][column] = marker;
    }
}
