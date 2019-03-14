package com.patryk.app;

import org.testng.annotations.Test;

/**
 * @author Patryk Kucharski
 */
@Test
public class PlayerTest {

    @Test
    public void createPlayerTest(){
        Player player = new Player("Patryk",false,Marker.CROSS);
        assert player.equals(new Player("Patryk",false,Marker.CROSS)) : "should be equal";
    }


}
