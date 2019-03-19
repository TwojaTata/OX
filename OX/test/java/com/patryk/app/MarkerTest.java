package com.patryk.app;

import com.patryk.app.models.Marker;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Patryk Kucharski
 */
@Test
public class MarkerTest {


    @DataProvider
    public static Object[][] markerDataProvider(){
        return new Object[][]{
                {Marker.CROSS,"X"},
                {Marker.CIRCLE,"O"},
                {Marker.BLANK," "}};
    }
    @Test(dataProvider = "markerDataProvider")
    public void createMarkerTest(Marker marker, String markerValue) {
        assert marker.valueToDisplay.equals(markerValue) : "should be equal";
    }


}
