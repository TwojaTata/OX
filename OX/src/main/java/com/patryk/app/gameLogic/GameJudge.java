package com.patryk.app.gameLogic;

import com.patryk.app.Board;
import com.patryk.app.Marker;
import com.patryk.app.Player;

import java.util.stream.Collectors;

/**
 * @author Patryk Kucharski
 */
class GameJudge {

    boolean validateIfMoveIsLegal(int row, int column, Board board) {
        if (board.board[row][column].equals(Marker.BLANK)){
            return true;
        }
        System.out.println("spot already taken! Specify different coordinates");
        return false;
    }

    boolean checkIfWonHorizontally(int row, int column, Board board) {

        int counter = 0;
        Marker currentMarker = board.players.stream()
                .filter(Player::hasTurn)
                .map(Player::getMarker)
                .collect(Collectors.toList())
                .get(0);


        for (int i = column; i < board.columns; i++) {
            if (board.board[row][i].equals(currentMarker)) {
                counter++;
                if (counter == board.winingConditionLength) {
                    return true;
                }
            } else break;
        }

        for (int i = column-1; i >= 0; i--) {
            if (board.board[row][i].equals(currentMarker)) {
                counter++;
                if (counter == board.winingConditionLength) {
                    return true;
                }
            } else break;
        }
        return false;

    }

    boolean checkIfWonVertically(int row, int column, Board board) {

        int counter = 0;
        Marker currentMarker = board.players.stream()
                .filter(Player::hasTurn)
                .map(Player::getMarker)
                .collect(Collectors.toList())
                .get(0);

        for (int i = row; i < board.rows; i++) {
            if (board.board[i][column].equals(currentMarker)) {
                counter++;
                if (counter == board.winingConditionLength) {
                    return true;
                }
            } else break;
        }

        for (int i = row-1; i >= 0; i--) {
            if (board.board[i][column].equals(currentMarker)) {
                counter++;
                if (counter == board.winingConditionLength) {
                    return true;
                }
            } else break;
        }
        return false;
    }

    boolean checkIfWonDiagonallyUpToDown(int row, int column, Board board) {

        int counter = 0;
        Marker currentMarker = board.players.stream()
                .filter(Player::hasTurn)
                .map(Player::getMarker)
                .collect(Collectors.toList())
                .get(0);

        for (int i = row, i1 = column; i < board.rows && i1 < board.columns; i++, i1++) {
            if (board.board[i][i1].equals(currentMarker)) {
                counter++;
                if (counter == board.winingConditionLength) {
                    return true;
                }
            } else break;
        }

        for (int i = row - 1, i1 = column - 1; i >= 0 && i1 >= 0; i--, i1--) {
            if (board.board[i][i1].equals(currentMarker)) {
                counter++;
                if (counter == board.winingConditionLength) {
                    return true;
                }
            } else break;
        }
        return false;
    }

    boolean checkIfWonDiagonallyDownToUp(int row, int column, Board board) {

        int counter = 0;
        Marker currentMarker = board.players.stream()
                .filter(Player::hasTurn)
                .map(Player::getMarker)
                .collect(Collectors.toList())
                .get(0);

        for (int i = row, i1 = column; i >= 0 && i1 < board.columns; i--, i1++) {
            if (board.board[i][i1].equals(currentMarker)) {
                counter++;
                if (counter == board.winingConditionLength) {
                    return true;
                }
            } else break;
        }

        for (int i = row + 1, i1 = column - 1; i < board.rows && i1 >= 0; i++, i1--) {
            if (board.board[i][i1].equals(currentMarker)) {
                counter++;
                if (counter == board.winingConditionLength) {
                    return true;
                }
            } else break;
        }
        return false;
    }

    boolean checkIfCurrentPlayerWon(int row, int column, Board board) {
        return checkIfWonDiagonallyDownToUp(row, column, board)
                || checkIfWonDiagonallyUpToDown(row, column, board)
                || checkIfWonHorizontally(row, column, board)
                || checkIfWonVertically(row, column, board);
    }

    public boolean checkIfTheresADraw(Board board) {
        int counter = 0;

        for (int i = 0; i < board.rows; i++) {
            for (int j = 0; j < board.columns; j++) {
                if (board.board[i][j].equals(Marker.BLANK)) {
                    counter++;
                }
            }
        }
        if (counter > 0) {
            return false;
        }
        return true;
    }
}
