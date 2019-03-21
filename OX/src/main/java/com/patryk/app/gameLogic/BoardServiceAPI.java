package com.patryk.app.gameLogic;

import com.patryk.app.Board;
import com.patryk.app.Player;

/**
 * @author Patryk Kucharski
 */
public class BoardServiceAPI {

    private BoardService boardService = new BoardService();
    private GameJudge gameJudge = new GameJudge();


    public void putMarker(Board board, int rows, int columns, Player currentPlayer) {
        boardService.putMarker(board, rows, columns, currentPlayer);
    }

    public Board initializeBoardOrResetBoard() {
        return boardService.setBoardConfigAndInitializeBoard(); //TODO tam jest zadyma trzeba to przepisać na API
    }

    public Board initializeDefaultBoard() {
        return boardService.initializeDefaultBoard();
    }

    public boolean validateIfMoveIsLegal(int row, int column, Board board) {
        return gameJudge.validateIfMoveIsLegal(row, column, board);
    }

    public int ConvertToInt(String coordinate) {
        return boardService.convertCoordinateToInt(coordinate);
    }

    public boolean checkIfWonHorizontally(int row, int column, Board board) {
        return gameJudge.checkIfWonHorizontally(row, column, board);
    }

    public boolean checkIfWonVertically(int row, int column, Board board) {
        return gameJudge.checkIfWonVertically(row, column, board);
    }

    public void switchTurns(Board board) {
        boardService.switchTurns(board);
    }

    public boolean checkIfWonDiagonallyUpToDown(int row, int column, Board board) {
        return gameJudge.checkIfWonDiagonallyUpToDown(row, column, board);
    }

    public boolean checkIfWonDiagonallyDownToUp(int row, int column, Board board) {
        return gameJudge.checkIfWonDiagonallyDownToUp(row, column, board);
    }

    public void displayBoard(Board board) {
        boardService.displayBoard(board);
    }

    public boolean checkIfCurrentPlayerWon(int row, int column, Board board) {
        return gameJudge.checkIfCurrentPlayerWon(row, column, board);
    }

    public boolean checkIfTheresADraw(Board board){
        return gameJudge.checkIfTheresADraw(board);
    }

    public Player getCurrentPLayer(Board board) {
        return boardService.getCurrentPlayer(board);
    }
}
