package com.patryk.app.output;

import org.testng.annotations.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.testng.Assert.*;

/**
 * @author Patryk Kucharski
 */
@Test
public class LanguageServiceTest {

    @Test
    public void resourceBundlePLTest(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("OX", new Locale("eng", "ENG"));
        assert resourceBundle.getString("player").equals("Player ");
    }

    @Test
    public void resourceBundleENGTest(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle("OX", new Locale("pl", "PL"));
        assert resourceBundle.getString("player").equals("Gracz ");
    }




}