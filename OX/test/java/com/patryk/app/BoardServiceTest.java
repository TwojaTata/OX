package com.patryk.app;

import com.patryk.app.gameLogic.BoardService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * @author Patryk Kucharski
 */
@Test
public class BoardServiceTest {

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

    @DataProvider(name = "putMarkerDP")
    public static Object[][] putMarkerDP() {
        return new Object[][]{
                {5,5},
                {0,0},
                {5,6},
                {5,8},
                {5,1}};
    }




}
