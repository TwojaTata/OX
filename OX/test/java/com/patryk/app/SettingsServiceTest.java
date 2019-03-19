package com.patryk.app;

import com.patryk.app.models.Board;
import com.patryk.app.models.Marker;
import com.patryk.app.services.SettingsService;
import org.testng.annotations.Test;

import java.util.Scanner;

/**
 * @author Patryk Kucharski
 */
@Test
public class SettingsServiceTest {

    @Test //TODO DP
    public void getMarkerFromPlayer_ResultTrue(){
        SettingsService settingsService = new SettingsService();
        assert settingsService.getMarkerBasedOnUserAnswer("o").get(0).equals(Marker.CIRCLE);
        assert settingsService.getMarkerBasedOnUserAnswer("X").get(0).equals(Marker.CROSS);
    }


}
