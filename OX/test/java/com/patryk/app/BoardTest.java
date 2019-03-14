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
    List<Player> players = new ArrayList<>();
    Board board = new Board(10,10,3,players);
    assert board.rows==10 : "should be 10 rows";
    assert board.columns==10 : "should be 10 columns";
    assert board.winingConditionLength==3 : "winnigCondition should be 3";

    }

    @Test void boardGeneratorLengthTest(){
    List<Player> players = new ArrayList<>();
    Board board = new Board(10,10,3,players);
    assert board.board.length==10 : "matrix should be length of 10";
    }

    @DataProvider(name = "matrixGeneratorDP")
    public static Object[][] matrixGeneratorDP() {
        return new Object[][]{
                {10,10,new Marker[10][10]},
                {10,20,new Marker[10][20]},
                {1000,1000,new Marker[1000][1000]},
                {1,1,new Marker[1][1]},
                {10000,1,new Marker[10000][1]},
                {60,50,new Marker[60][50]},
        };
    }

    @Test(dataProvider = "matrixGeneratorDP")
    public void boardGeneratorMatrixTest(int rows, int columns, Marker[][] result){
        List<Player> players = new ArrayList<>();
        Board board = new Board(rows,columns,3,players);
        assert Arrays.deepEquals(board.board, result) : "both should be the same";
    }
}
