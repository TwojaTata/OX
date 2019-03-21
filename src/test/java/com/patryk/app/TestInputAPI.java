package com.patryk.app;

import com.patryk.app.input.InputAPI;
import com.patryk.app.input.InputValidationService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Patryk Kucharski
 */
@Test
public class TestInputAPI {

    @DataProvider(name = "validateDimensionDP")
    public static Object[][] validateDimensionDP() {
        return new Object[][]{
                {"4"},
                {"10"},
                {"40"},
                {"20"},
                {"3"},};
    }

    @Test(dataProvider = "validateDimensionDP")
    public void validateBoardDimensionTest_ResultTrue(String dimension) throws NumberFormatException {
        InputAPI inputAPI = new InputAPI();
        assert inputAPI.validateDimension(dimension) : "should be true";
    }

    @Test//TODO DP
    public void validateNameTest_ResultTrue(){
        InputAPI inputAPI = new InputAPI();
        assert inputAPI.validateName("name") : "should be true";
    }

    @Test
    public void validateWinningConditionTest_ResultTrue(){
        InputAPI inputAPI = new InputAPI();
        assert inputAPI.validateWiningCondition("5", 10) : "should be true";
    }
}
