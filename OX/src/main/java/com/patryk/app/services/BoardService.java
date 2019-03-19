package com.patryk.app.services;

import com.patryk.app.models.Board;
import com.patryk.app.models.Marker;

/**
 * @author Patryk Kucharski
 * <p>
 * Service to manage board.
 * Contains methods to initialize blank board,
 * put marker on board and add player to the borad.
 */
public class BoardService {

    Board board;
    SettingsService settingsService = new SettingsService();


    public void setBoardConfigAndInitializeBoard() {
        board = new Board(settingsService.getDimensionFromUser("rows"),
                settingsService.getDimensionFromUser("columns"),
                settingsService.getWiningConditionLengthFromUser());
        board.players = settingsService.getPlayersInfoFromUser();
        fillBoardWithBlanks(board);
    }

    public void displayPlayersInfo() {
        System.out.println(board.players.toString());
    }

    /**
     * Sets up a board filled with Marker.BLANK enum,
     * such board is ready to play
     */

    public void fillBoardWithBlanks(Board board) {
        for (int i = 0; i < board.rows; i++) {
            for (int j = 0; j < board.columns; j++) {
                board.board[i][j] = Marker.BLANK;
            }
        }
    }

    /**
     * @param row
     * @param column
     * @param marker Puts given marker in specified position on board (row, column)
     */

    public void putMarker(int row, int column, Marker marker) {//TODO walidacja tutaj???? raczej nie, DO innej klasy -> GameService
        board.board[row][column] = marker;
    }

    /**
     * displays current state of a board;
     */

    public void displayBoard() { //TODO do innej klasy GameService? Poładnić to

        System.out.println();
        System.out.print("   ");
        for (int i = 0; i < board.rows; i++) {
            if (i+1>9){
            System.out.print("|" + (i + 1) + " ");
        } else {
                System.out.print("|" + (i + 1) + "  ");
            }

        }
        System.out.print("|");
        System.out.println();
        for (int k = 0; k < board.columns + 1; k++) {
            System.out.print("----");
        }
        for (int i = 0; i < board.rows; i++) {
            System.out.println();
            if (i+1>9) {
                System.out.print((i + 1) + " ");
            }else {
                System.out.print((i + 1) + "  ");
            }
            for (int j = 0; j < board.columns; j++) {
                System.out.print("| " + board.board[i][j].valueToDisplay + " ");
            }
            System.out.print("|");
            System.out.println();
            for (int k = 0; k < board.columns + 1; k++) {
                System.out.print("----");
            }
        }
    }
}
