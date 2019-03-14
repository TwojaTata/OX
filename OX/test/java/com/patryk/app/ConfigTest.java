package com.patryk.app;

import org.testng.annotations.Test;

/**
 * @author Patryk Kucharski
 */
@Test
public class ConfigTest {

    @Test
    public void createConfigTest_newConfig(){
        Config config = new Config("ENG");
        assert config.equals(config.setConfig("ENG")) : "should be exactly the same thing";
    }
    @Test
    public void changeConfigTest(){
        Config config = new Config("ENG");
        Config configDE = new Config("DE");
        config.setConfig("PL");
        config.setConfig("DE");
        assert config.equals(configDE) : "should be equal"; //TODO nie przechodzi
    }

}
