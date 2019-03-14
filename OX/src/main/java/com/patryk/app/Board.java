package com.patryk.app;

import java.util.Arrays;
import java.util.List;

/**
 * @author Patryk Kucharski
 *
 *
 * Represents board, and contains methods to display, initialize and put given marker
 *
 *
 */
public class Board extends BoardConfig{

    public Marker[][] board;



    public Board(int rows, int columns, int winningCondition){
        super(rows, columns, winningCondition);
        this.board = new Marker[super.rows][super.columns];
    }
/**
 *Sets up a board filled with Marker.BLANK enum,
 *such board is ready to play
*/


    public void fillBoardWithBlanks(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = Marker.BLANK;
            }
        }
    }

    /**
     *
      * @param row
     * @param column
     * @param marker
     *
     * Puts given marker in specified position on board (row, column)
     */

    public void putMarker(int row, int column, Marker marker) {//TODO walidacja tutaj???? raczej nie
        board[row][column] = marker;
    }

    /**
     *
     */
    public void displayBoard(){
        for (int i = 0; i < rows; i++) {
            System.out.println();
            for (int j = 0; j < columns; j++) {
                System.out.print("[" + board[i][j].valueToDisplay + "]");
            }
        }
    }
}
