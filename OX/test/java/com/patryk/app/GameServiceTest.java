package com.patryk.app;

import com.patryk.app.models.Board;
import com.patryk.app.services.GameService;
import org.testng.annotations.Test;

/**
 * @author Patryk Kucharski
 */
@Test
public class GameServiceTest {

    @Test
    public void putAMarkerOnBoardTest_ResultTrue(){
        GameService gameService = new GameService();
        Board board = new Board(5,5,5);



    }
}
