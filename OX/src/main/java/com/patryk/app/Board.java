package com.patryk.app;

import java.util.Arrays;
import java.util.List;

/**
 * @author Patryk Kucharski
 */
public class Board extends BoardConfig{

    public Marker[][] board;

    public Board(int rows, int columns, int winningCondition){
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
    public void displayBoard(){
        for (int i = 0; i < rows; i++) {
            System.out.println();
            for (int j = 0; j < columns; j++) {
                System.out.print("[" + board[i][j].valueToDisplay + "]");
            }
        }
    }
}
