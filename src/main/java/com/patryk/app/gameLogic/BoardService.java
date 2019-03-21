package com.patryk.app.gameLogic;

import com.patryk.app.Board;
import com.patryk.app.Marker;
import com.patryk.app.Player;
import com.patryk.app.output.SettingsService;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * @author Patryk Kucharski
 * <p>
 * Service to manage board.
 * Contains methods to initialize blank board,
 * create board accordingly to user input,
 * put marker on board and add player to the borad.
 */
public class BoardService {

    private Board board;
    private SettingsService settingsService = new SettingsService();

    /**
     * @return customized board accordingly to user input,
     * such board is ready to play
     */

    Board setBoardConfigAndInitializeBoard() {
        board = new Board(settingsService.getDimensionFromUser("rows"),
                settingsService.getDimensionFromUser("columns"),
                settingsService.getWiningConditionLengthFromUser());
        board.players = settingsService.getPlayersInfoFromUser();
        fillBoardWithBlanks(board);
        return board;
    }

    /**
     * @return default board, with default players and settings
     * such board is ready to play
     */

    Board initializeDefaultBoard() {
        board = new Board(3, 3, 3);
        board.players = new ArrayList<>(2);
        board.players.add(new Player("PlayerO", true, Marker.CIRCLE));
        board.players.add(new Player("PlayerX", false, Marker.CROSS));
        fillBoardWithBlanks(board);
        return board;
    }

    /**
     * Sets up a board filled with Marker.BLANK enum,
     * which is initial state of board
     */

    private void fillBoardWithBlanks(Board board) {
        for (int i = 0; i < board.rows; i++) {
            for (int j = 0; j < board.columns; j++) {
                board.board[i][j] = Marker.BLANK;
            }
        }
    }

    /**
     * @param row           coordinate
     * @param column        coordinate
     * @param currentPlayer player who currently has turn
     *                      <p>
     *                      Puts given marker in specified position on board
     */

    void putMarker(Board board, int row, int column, Player currentPlayer) {
        board.board[row][column] = currentPlayer.getMarker();
    }

    /**
     * displays current state of a board;
     */

    void displayBoard(Board board) {

        System.out.println();
        System.out.print("   ");
        for (int i = 0; i < board.columns; i++) {
            if (i + 1 > 9) {
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
            if (i + 1 > 9) {
                System.out.print((i + 1) + " ");
            } else {
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
        System.out.println();
        System.out.println();
    }

    int convertCoordinateToInt(String coordinate) {
        return Integer.valueOf(coordinate);
    }


    void switchTurns(Board board) {
        for (Player player : board.players
        ) {
            if (player.hasTurn()) {
                player.setTurn(false);
            } else {
                player.setTurn(true);
            }
        }
    }

    Player getCurrentPlayer(Board board) {
        return board.players.stream()
                .filter(Player::hasTurn)
                .collect(Collectors.toList())
                .get(0);

    }
}
