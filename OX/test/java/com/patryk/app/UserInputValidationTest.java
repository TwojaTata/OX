package com.patryk.app;

import com.patryk.app.services.InputValidationService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Patryk Kucharski
 */
@Test
public class UserInputValidationTest {

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
        InputValidationService inputValidationService = new InputValidationService();
        assert inputValidationService.validateDimension(dimension) : "should be true";
    }

    @Test//TODO DP
    public void validateNameTest_ResultTrue(){
        InputValidationService inputValidationService = new InputValidationService();
        assert inputValidationService.validateName("name") : "should be true";
    }

    @Test
    public void validateWinningConditionTest_ResultTrue(){
        InputValidationService inputValidationService = new InputValidationService();
        assert inputValidationService.validateWiningCondition("5", 10) : "should be true";
    }
}
