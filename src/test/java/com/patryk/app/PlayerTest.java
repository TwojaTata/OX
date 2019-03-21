package com.patryk.app;

import org.testng.annotations.Test;

/**
 * @author Patryk Kucharski
 */
@Test
public class PlayerTest {

    @Test
    public void createPlayerTest(){
        Player player = new Player("Patryk",false, Marker.CROSS);
        assert player.equals(new Player("Patryk",false,Marker.CROSS)) : "should be equal";
    }

    @Test
    public void toStringTest(){
        Player player = new Player("imię",false,Marker.CROSS);
        assert player.toString().equals("Current Player: imię Marker: X");
    }

    @Test
    public void getNameTest(){
        Player player = new Player("imię",false,Marker.CROSS);
        assert player.getName().equals("imię");
    }
}
