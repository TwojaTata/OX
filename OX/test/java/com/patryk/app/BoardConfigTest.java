package com.patryk.app;

import org.testng.annotations.Test;

/**
 * @author Patryk Kucharski
 *
 */
@Test
public class BoardConfigTest {

    @Test
    public void createNewBoardConfigTest(){
        BoardConfig boardConfig = new BoardConfig();
        assert boardConfig.equals(new BoardConfig()) : "should be equal";
    }
    @Test
    public void addAPlayerTest(){
        Player player = new Player("patryk", false, Marker.CROSS);
        BoardConfig boardConfig = new BoardConfig();
        boardConfig.addPlayer(player);
        assert boardConfig.players.get(0).equals(new Player("patryk", false,Marker.CROSS));
    }

    @Test
    public void addPlayerTestNO2(){
        Player player = new Player("patryk", false, Marker.CROSS);
        BoardConfig boardConfig = new BoardConfig();
        boardConfig.addPlayer(player);
        assert boardConfig.players.get(0).equals(player) : "should be equal";
    }

}
