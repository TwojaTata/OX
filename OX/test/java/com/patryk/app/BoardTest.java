package com.patryk.app;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Patryk Kucharski
 */
@Test
public class BoardTest {

    @Test
    public void createBoardTest(){
    Board board = new Board(10,10,3);
    assert board.rows==10 : "should be 10 rows";
    assert board.columns==10 : "should be 10 columns";
    assert board.winingConditionLength==3 : "winnigCondition should be 3";

    }

    @Test void boardGeneratorLengthTest(){
    Board board = new Board(10,10,3);
    assert board.board.length==10 : "matrix should be length of 10";
    }

    @DataProvider(name = "matrixGeneratorDP")
    public static Object[][] matrixGeneratorDP() {
        return new Object[][]{
                {10,10,new Marker[10][10]},
                {10,20,new Marker[10][20]},
                {10,10,new Marker[10][10]},
                {1,1,new Marker[1][1]},
                {100,1,new Marker[100][1]},
                {60,50,new Marker[60][50]},
        };
    }

    @Test(dataProvider = "matrixGeneratorDP")
    public void boardGeneratorMatrixTest(int rows, int columns, Marker[][] result){
        Board board = new Board(rows,columns,3);
        assert Arrays.deepEquals(board.board, result) : "both should be the same";
    }

    @DataProvider(name = "blankBoardDP")
    public static Object[][] blankBoardDP() {
        return new Object[][]{
                {1,1,Marker.BLANK},
                {9,6,Marker.BLANK},
                {5,5,Marker.BLANK},
                {0,1,Marker.BLANK},
                {1,0,Marker.BLANK},};
    }

    @Test(dataProvider = "blankBoardDP")
    public void fillBoardWithBlanksTest(int rows, int columns, Marker markerBlank){
        Board board = new Board(10,10,5);
        board.fillBoardWithBlanks();
        assert board.board[rows][columns].equals(markerBlank) : "all field should be blanks";
    }

    @Test
    public void putMarkerOnAGivenSlot(){
        Board board = new Board(10,10,5);
        board.fillBoardWithBlanks();
        board.putMarker(5,5,Marker.CIRCLE);
        assert board.board[5][5].equals(Marker.CIRCLE): "should be circle";
    }
}
