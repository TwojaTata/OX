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


}
