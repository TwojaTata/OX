package com.patryk.app.gameLogic;

import com.patryk.app.Board;
import com.patryk.app.Marker;
import com.patryk.app.Player;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.*;

/**
 * @author Patryk Kucharski
 */
@Test
public class BoardServiceAPITest {

    @Test
    public void testPutMarker() {

        BoardServiceAPI boardServiceAPI = new BoardServiceAPI();
        Board board = boardServiceAPI.initializeDefaultBoard();
        boardServiceAPI.putMarker(board, 2,2,board.players.get(0));
        assert board.board[2][2].equals(board.players.get(0).getMarker());
    }

    @DataProvider(name = "defaultBoardDP")
    public static Object[][] defaultBoardDP() {
        return new Object[][]{
                {0,0,Marker.BLANK},
                {0,1,Marker.BLANK},
                {0,2,Marker.BLANK},
                {1,0,Marker.BLANK},
                {1,1,Marker.BLANK},
                {1,2,Marker.BLANK},
                {2,0,Marker.BLANK},
                {2,1,Marker.BLANK},
                {2,2,Marker.BLANK},};
    }

    @Test(dataProvider = "defaultBoardDP")
    public void testInitializeDefaultBoard(int row, int column, Marker marker) {

        BoardServiceAPI boardServiceAPI = new BoardServiceAPI();
        Board board = boardServiceAPI.initializeDefaultBoard();
        assert board.board[row][column].equals(marker) : "should be equal";
    }

    @Test
    public void testConvertToInt(){
        BoardServiceAPI boardServiceAPI = new BoardServiceAPI();
        assert boardServiceAPI.ConvertToInt("2")==2;
    }

    @Test
    public void testMoveValidation(){
        BoardServiceAPI boardServiceAPI = new BoardServiceAPI();
        Board board = boardServiceAPI.initializeDefaultBoard();
        boardServiceAPI.putMarker(board, 2,2,board.players.get(0));
        assert !boardServiceAPI.validateIfMoveIsLegal(2,2,board);
    }
    @Test
    public void testCheckIfWonHorizontally_ResultTrue(){
        BoardServiceAPI boardServiceAPI = new BoardServiceAPI();
        Board board = boardServiceAPI.initializeDefaultBoard();
        boardServiceAPI.putMarker(board,0,0,board.players.get(0));
        boardServiceAPI.putMarker(board,0,1,board.players.get(0));
        boardServiceAPI.putMarker(board,0,2,board.players.get(0));

        assert boardServiceAPI.checkIfWonHorizontally(0,0,board);
    }

    @Test
    public void testCheckIfWonHorizontally_ResultFalse(){
        BoardServiceAPI boardServiceAPI = new BoardServiceAPI();
        Board board = boardServiceAPI.initializeDefaultBoard();
        boardServiceAPI.putMarker(board,0,0,board.players.get(0));
        boardServiceAPI.putMarker(board,1,1,board.players.get(0));
        boardServiceAPI.putMarker(board,0,2,board.players.get(0));

        assert !boardServiceAPI.checkIfWonHorizontally(0,0,board);
    }

    @Test
    public void testCheckIfWonVertically_ResultTrue(){
        BoardServiceAPI boardServiceAPI = new BoardServiceAPI();
        Board board = boardServiceAPI.initializeDefaultBoard();
        boardServiceAPI.putMarker(board,0,0,board.players.get(0));
        boardServiceAPI.putMarker(board,1,0,board.players.get(0));
        boardServiceAPI.putMarker(board,2,0,board.players.get(0));

        assert boardServiceAPI.checkIfWonVertically(0,0,board);
    }

    @Test
    public void testCheckIfWonVertically_ResultFalse(){
        BoardServiceAPI boardServiceAPI = new BoardServiceAPI();
        Board board = boardServiceAPI.initializeDefaultBoard();
        boardServiceAPI.putMarker(board,0,0,board.players.get(0));
        boardServiceAPI.putMarker(board,1,1,board.players.get(0));
        boardServiceAPI.putMarker(board,0,2,board.players.get(0));

        assert !boardServiceAPI.checkIfWonVertically(0,0,board);
    }

    @Test
    public void testSwitchTurn_ResultTrue(){
        BoardServiceAPI boardServiceAPI = new BoardServiceAPI();
        Board board = boardServiceAPI.initializeDefaultBoard();
        boardServiceAPI.switchTurns(board);
        assert !board.players.get(0).hasTurn();
    }

    @Test
    public void testSwitchTurn_ResultFalse(){
        BoardServiceAPI boardServiceAPI = new BoardServiceAPI();
        Board board = boardServiceAPI.initializeDefaultBoard();
        boardServiceAPI.switchTurns(board);
        assert board.players.get(1).hasTurn();
    }


    @Test
    public void testSwitchTurnTwice_ResultTrue(){
        BoardServiceAPI boardServiceAPI = new BoardServiceAPI();
        Board board = boardServiceAPI.initializeDefaultBoard();
        boardServiceAPI.switchTurns(board);
        boardServiceAPI.switchTurns(board);
        assert board.players.get(0).hasTurn();
    }

    @Test
    public void testSwitchTurnTwice_ResultFalse(){
        BoardServiceAPI boardServiceAPI = new BoardServiceAPI();
        Board board = boardServiceAPI.initializeDefaultBoard();
        boardServiceAPI.switchTurns(board);
        boardServiceAPI.switchTurns(board);
        assert !board.players.get(1).hasTurn();
    }

    @Test
    public void testCheckIfWonDiagonallyUpToDown_ResultTrue() {
        BoardServiceAPI boardServiceAPI = new BoardServiceAPI();
        Board board = boardServiceAPI.initializeDefaultBoard();
        boardServiceAPI.putMarker(board, 0, 0, board.players.get(0));
        boardServiceAPI.putMarker(board, 1, 1, board.players.get(0));
        boardServiceAPI.putMarker(board, 2, 2, board.players.get(0));

        assert boardServiceAPI.checkIfWonDiagonallyUpToDown(2, 2, board);
    }
    @Test
    public void testCheckIfWonDiagonallyUpToDown_ResultFalse() {
        BoardServiceAPI boardServiceAPI = new BoardServiceAPI();
        Board board = boardServiceAPI.initializeDefaultBoard();
        boardServiceAPI.putMarker(board, 0, 0, board.players.get(0));
        boardServiceAPI.putMarker(board, 2, 1, board.players.get(0));
        boardServiceAPI.putMarker(board, 2, 2, board.players.get(0));

        assert !boardServiceAPI.checkIfWonDiagonallyUpToDown(0, 0, board);
    }
    @Test
    public void testCheckIfWonDiagonallyDownToUp_ResultTrue() {
        BoardServiceAPI boardServiceAPI = new BoardServiceAPI();
        Board board = boardServiceAPI.initializeDefaultBoard();
        boardServiceAPI.putMarker(board, 2, 0, board.players.get(0));
        boardServiceAPI.putMarker(board, 1, 1, board.players.get(0));
        boardServiceAPI.putMarker(board, 0, 2, board.players.get(0));

        assert boardServiceAPI.checkIfWonDiagonallyDownToUp(1, 1, board);
    }
    @Test
    public void testCheckIfWonDiagonallyDownToUp_ResultFalse() {
        BoardServiceAPI boardServiceAPI = new BoardServiceAPI();
        Board board = boardServiceAPI.initializeDefaultBoard();
        boardServiceAPI.putMarker(board, 2, 0, board.players.get(0));
        boardServiceAPI.putMarker(board, 2, 1, board.players.get(0));
        boardServiceAPI.putMarker(board, 0, 2, board.players.get(0));

        assert !boardServiceAPI.checkIfWonDiagonallyDownToUp(0, 2, board);
    }
}