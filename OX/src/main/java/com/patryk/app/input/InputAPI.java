package com.patryk.app.input;

import com.patryk.app.Board;

/**
 * @author Patryk Kucharski
 */
public class InputAPI {

    private InputValidationService inputValidationService = new InputValidationService();

    public boolean validateDimension(String dimension) {
        return inputValidationService.validateDimension(dimension);
    }

    public boolean validateName(String name) {
        return inputValidationService.validateName(name);
    }

    public boolean validateWiningCondition(String winingCondition, int biggerBoardDimension) {
        return inputValidationService.validateWiningCondition(winingCondition, biggerBoardDimension);
    }

    public boolean validateMarker(String markerPlayerOne) {
        return inputValidationService.validateMarker(markerPlayerOne);
    }

    public boolean validateCoordinate(String coordinate, String coordinateName, Board board) {
        return inputValidationService.validateCoordinate(coordinate, coordinateName, board);
    }

}
