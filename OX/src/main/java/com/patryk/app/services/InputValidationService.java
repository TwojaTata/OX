package com.patryk.app.services;

import com.patryk.app.models.Board;
import com.patryk.app.models.Marker;

import java.util.Scanner;

/**
 * @author Patryk Kucharski
 */
public class InputValidationService {


    public boolean validateDimension(String dimension) {
        int dimensionInt;
        Scanner scanner = new Scanner(System.in);

        if (dimension == null) {
            return false;
        }
        try {
            dimensionInt = Integer.valueOf(dimension);
        } catch (NumberFormatException e) {
            System.out.println("not a proper number");
            return false;
        }
        if (dimensionInt < 3) {
            System.out.println("dimension can't be smaller than 3");
            System.out.println("insert proper one");
            return false;
        }
        if (dimensionInt > 99) {
            System.out.println("Given number is too big to draw");
            System.out.println("insert proper one");
            return false;
        }
        return true;
    }

    public boolean validateName(String name) {
        if (name == null) {
            return false;
        }
        if (name.length() > 30) {
            System.out.println("Given name is too long");
            System.out.println("insert proper one!");
            return false;
        }
        return true;
    }

    public boolean validateWiningCondition(String winingCondition, int biggerBoardDimension) {
        int winingConditionInt;

        if (winingCondition == null) {
            return false;
        }
        try {
            winingConditionInt = Integer.valueOf(winingCondition);
        } catch (NumberFormatException e) {
            System.out.println("not a proper number");
            System.out.println("insert proper one!");
            return false;
        }
        if (winingConditionInt < 3) {
            System.out.println("wining condition can't be smaller than 3");
            return false;
        }
        if (winingConditionInt > biggerBoardDimension) {
            System.out.println("wining condition impossible to fulfill");
            return false;
        }
        return true;
    }

    public boolean validateMarker(String markerPlayerOne) {

        if (markerPlayerOne == null) {
            return false;
        }
        if (markerPlayerOne.toLowerCase().equals("x") || markerPlayerOne.toLowerCase().equals("o")) {
            return true;
        }//TODO więcej warunków
        System.out.println("I'm not sure what you mean");
        System.out.println("insert marker one more time");
        return false;
    }

    public boolean validateCoordinate(String coordinate, String coordinateName, Board board) {
        int coordinateInt;

        try {
            coordinateInt = Integer.valueOf(coordinate);
        } catch (NumberFormatException e) {
            System.out.println("not a proper number");
            System.out.println("insert proper one!");
            return false;
        }
        if (coordinateInt < 0) {
            System.out.println("there's no such field");
            return false;
        }
        if (coordinateName.equals("rows")) {
            if (coordinateInt > board.rows) {
                System.out.println("out of board!");
                return false;
            }
        }
        if (coordinateName.equals("columns")){
            if (coordinateInt > board.columns){
                System.out.println("out of board");
                return false;
            }
        }
        return true;
    }
}
