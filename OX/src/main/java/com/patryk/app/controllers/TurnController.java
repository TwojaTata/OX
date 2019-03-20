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

    void doARound(Board board) {
        do {
            doATurn(board);
        }while (!doWeHaveAWinner);
    }

    private void doATurn(Board board) {
        Player currentPlayer = boardServiceAPI.getCurrentPLayer(board);//TODO iplementacja
        boardServiceAPI.displayBoard(board);
        outputAPI.printCurrentPlayer(board);
        String userAnswerRow = outputAPI.askForRow();
        inputAPI.validateCoordinate(userAnswerRow, "rows", board);
        int row = boardServiceAPI.ConvertToInt(userAnswerRow);
        String userAnswerColumn = outputAPI.askForColumn();//TODO implementacja
        inputAPI.validateCoordinate(userAnswerColumn, "columns", board);
        int column = boardServiceAPI.ConvertToInt(userAnswerColumn);
        boardServiceAPI.validateIfMoveIsLegal(row, column, board);
        boardServiceAPI.putMarker(board, row, column, currentPlayer);
        if (boardServiceAPI.checkIfCurrentPlayerWon(row, column,board)){
            outputAPI.printMessage("Wygrał " + currentPlayer.getName());
            doWeHaveAWinner = true;
        }
        boardServiceAPI.switchTurns(board);//TODO DZIAŁA ALE SIĘ WYPIERDALA
    }

}
