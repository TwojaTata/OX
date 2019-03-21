package com.patryk.app.controllers;

import com.patryk.app.Board;
import com.patryk.app.Player;
import com.patryk.app.gameLogic.BoardServiceAPI;
import com.patryk.app.input.InputAPI;
import com.patryk.app.output.OutputAPI;

/**
 * @author Patryk Kucharski
 */
class TurnController {

    private BoardServiceAPI boardServiceAPI = new BoardServiceAPI();
    private InputAPI inputAPI = new InputAPI();
    private OutputAPI outputAPI = new OutputAPI();
    private boolean doWeHaveAWinner = false;
    private boolean doWeHaveADraw = false;
    private boolean isRowValid = false;
    private boolean isColumnValid = false;
    private int row, column;
    private String userAnswerRow;
    private String userAnswerColumn;


    void doARound(Board board) {
        resetSettings();
        while (!doWeHaveAWinner || !doWeHaveADraw) {
            doATurn(board);
        }
    }

    private void doATurn(Board board) {
        Player currentPlayer = boardServiceAPI.getCurrentPLayer(board);
        boardServiceAPI.displayBoard(board);
        outputAPI.printCurrentPlayer(board);
        validateMove(board);
        boardServiceAPI.putMarker(board, row - 1, column - 1, currentPlayer);
        if (boardServiceAPI.checkIfCurrentPlayerWon(row - 1, column - 1, board)) {
            boardServiceAPI.displayBoard(board);
            outputAPI.printMessageToUserInLine("player");
            outputAPI.printMessage(currentPlayer.getName());
            outputAPI.printMessageToUserInLine("won");
            outputAPI.printMessage("");
            doWeHaveAWinner = true;
            doWeHaveADraw = true;
        }
        if (!doWeHaveAWinner) {
            if (boardServiceAPI.checkIfTheresADraw(board)) {
                boardServiceAPI.displayBoard(board);
                outputAPI.printMessageToUserNextLine("itsADraw");
                doWeHaveADraw = true;
                doWeHaveAWinner = true;
            }
        }
        boardServiceAPI.switchTurns(board);
    }

    private void validateMove(Board board) {
        boolean isMoveValid;
        do {
            validateRow(board);
            validateColumn(board);
            isMoveValid = boardServiceAPI.validateIfMoveIsLegal(row - 1, column - 1, board);
        } while (!isMoveValid);
    }

    private void validateRow(Board board) {
        do {
            userAnswerRow = outputAPI.askForRow();
            isRowValid = inputAPI.validateCoordinate(userAnswerRow, "rows", board);
        } while (!isRowValid);
        row = boardServiceAPI.ConvertToInt(userAnswerRow);
    }

    private void validateColumn(Board board) {
        do {
            userAnswerColumn = outputAPI.askForColumn();
            isColumnValid = inputAPI.validateCoordinate(userAnswerColumn, "columns", board);
        } while (!isColumnValid);
        column = boardServiceAPI.ConvertToInt(userAnswerColumn);
    }
    private void resetSettings(){
        doWeHaveAWinner=false;
        doWeHaveADraw=false;
    }

}
