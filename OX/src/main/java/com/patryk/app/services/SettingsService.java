package com.patryk.app.services;

import com.patryk.app.models.Marker;
import com.patryk.app.models.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Patryk Kucharski
 * <p>
 * Service to get dimensions and wining condition from user
 */
public class SettingsService {

    InputValidationService inputValidationService = new InputValidationService();
    Scanner scanner = new Scanner(System.in);
    int rows;
    int columns;

    public SettingsService() {
    }

    /**
     * @param
     * @return
     */
    public int getBiggerDimension(int rows, int columns) {
        if (rows > columns) {
            return rows;
        }
        return columns;
    }

    /**
     * @param dimensionName
     */
    public int getDimensionFromUser(String dimensionName) {
        String userAnswer;

        do {
            System.out.println("insert number of " + dimensionName);
            userAnswer = scanner.nextLine();
        } while (!inputValidationService.validateDimension(userAnswer));
        if (dimensionName.equals("rows")){
            rows = Integer.valueOf(userAnswer);
        }else {
            columns = Integer.valueOf(userAnswer);
        }
        return Integer.valueOf(userAnswer);
    }

    /**
     * @param
     * @return
     */

    public int getWiningConditionLengthFromUser() {
        String userAnswer;

        do {
            System.out.println("insert number of wining marks in a row");//TODO wymyślić dobre pytanie
            userAnswer = scanner.nextLine();
        } while (!inputValidationService.validateWiningCondition(userAnswer, getBiggerDimension(rows, columns)));
        return Integer.valueOf(userAnswer);
    }

    public List<Player> getPlayersInfoFromUser() {
        String userAnswerPlayerOneName;
        String userAnswerPlayerTwoName;
        String markerPlayerOne;
        List<Player> players = new ArrayList<>(2);

        do {
            System.out.println("Insert name of player to begin");
            userAnswerPlayerOneName = scanner.nextLine();
        } while (!inputValidationService.validateName(userAnswerPlayerOneName));

        do {
            System.out.println("Insert marker of " + userAnswerPlayerOneName + " (O,X)");
            markerPlayerOne = scanner.nextLine();
        } while (!inputValidationService.validateMarker(markerPlayerOne));

        do {
            System.out.println("Insert name of second player");
            userAnswerPlayerTwoName = scanner.nextLine();
        } while (!inputValidationService.validateName(userAnswerPlayerTwoName));

        players.add(new Player(userAnswerPlayerOneName, true, getMarkerBasedOnUserAnswer(markerPlayerOne).get(0)));
        players.add(new Player(userAnswerPlayerTwoName, false, getMarkerBasedOnUserAnswer(markerPlayerOne).get(1)));
        return players;
    }

    public List<Marker> getMarkerBasedOnUserAnswer(String markerPlayerOne) {

        List<Marker> markers = new ArrayList<>(2);
        if (markerPlayerOne == null) {
            return null;//TODO ????? co z  tym nullem
        }
        if (markerPlayerOne.toLowerCase().equals("o") || markerPlayerOne.toLowerCase().equals("0") || markerPlayerOne.toLowerCase().equals("circle")) {
            markers.add(Marker.CIRCLE);
            markers.add(Marker.CROSS);
        }
        if (markerPlayerOne.toLowerCase().equals("x") || markerPlayerOne.toLowerCase().equals("+") || markerPlayerOne.toLowerCase().equals("cross")) {
            markers.add(Marker.CROSS);
            markers.add(Marker.CIRCLE);
        }
        return markers;
    }
}
