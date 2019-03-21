package com.patryk.app.input;

import com.patryk.app.Board;
import com.patryk.app.output.OutputAPI;

/**
 * @author Patryk Kucharski
 *
 * class to check for user input and prevent
 * any exceptions or interruptions to occur at runtime
 */
public class InputValidationService {

    private OutputAPI outputAPI = new OutputAPI();

    boolean validateDimension(String dimension) {
        int dimensionInt;

        if (dimension == null) {
            return false;
        }
        try {
            dimensionInt = Integer.valueOf(dimension);
        } catch (NumberFormatException e) {
            outputAPI.printMessageToUserNextLine("notAProperNumber");
            return false;
        }
        if (dimensionInt < 3) {

            outputAPI.printMessageToUserNextLine("dimensionTooSmall");
            outputAPI.printMessageToUserNextLine("insertProperNumber");
            return false;
        }
        if (dimensionInt > 99) {
            outputAPI.printMessageToUserNextLine("dimensionTooBig");
            outputAPI.printMessageToUserNextLine("insertProperNumber");
            return false;
        }
        return true;
    }

    boolean validateName(String name) {
        if (name == null) {
            return false;
        }
        if (name.length() > 30) {
            outputAPI.printMessageToUserNextLine("nameTooLong");
            outputAPI.printMessageToUserNextLine("insertProperName");

            return false;
        }
        return true;
    }

    boolean validateWiningCondition(String winingCondition, int biggerBoardDimension) {
        int winingConditionInt;

        if (winingCondition == null) {
            return false;
        }
        try {
            winingConditionInt = Integer.valueOf(winingCondition);
        } catch (NumberFormatException e) {
            outputAPI.printMessageToUserNextLine("notAProperNumber");
            outputAPI.printMessageToUserNextLine("insertProperNumber");
            return false;
        }
        if (winingConditionInt < 3) {
            outputAPI.printMessageToUserNextLine("winingConditionTooSmall");
            return false;
        }
        if (winingConditionInt > biggerBoardDimension) {
            outputAPI.printMessageToUserNextLine("conditionImpossibleToFulfill");
            return false;
        }
        return true;
    }

    boolean validateMarker(String markerPlayerOne) {

        if (markerPlayerOne == null) {
            return false;
        }
        if (markerPlayerOne.toLowerCase().equals("x") || markerPlayerOne.toLowerCase().equals("o")) {
            return true;
        }
        outputAPI.printMessageToUserNextLine("notSureWhatYouMean");
        outputAPI.printMessageToUserNextLine("insertMarkerAgain");
        return false;
    }

    boolean validateCoordinate(String coordinate, String coordinateName, Board board) {
        int coordinateInt;

        try {
            coordinateInt = Integer.valueOf(coordinate);
        } catch (NumberFormatException e) {
            outputAPI.printMessageToUserNextLine("notAProperNumber");
            outputAPI.printMessageToUserNextLine("insertProperNumber");
            return false;
        }
        if (coordinateInt < 0) {
            outputAPI.printMessageToUserNextLine("noSuchField");
            return false;
        }
        if (coordinateName.equals("rows")) {
            if (coordinateInt > board.rows) {
                outputAPI.printMessageToUserNextLine("outOfBoard");
                return false;
            }
        }
        if (coordinateName.equals("columns")){
            if (coordinateInt > board.columns){
                outputAPI.printMessageToUserNextLine("outOfBoard");
                return false;
            }
        }
        return true;
    }
}
