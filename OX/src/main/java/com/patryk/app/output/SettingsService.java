package com.patryk.app.output;

import com.patryk.app.input.InputAPI;
import com.patryk.app.Marker;
import com.patryk.app.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Patryk Kucharski
 * <p>
 * Service to get game config from user
 */
public class SettingsService {

    private OutputAPI outputAPI = new OutputAPI();
    private InputAPI inputApi = new InputAPI();
    private Scanner scanner = new Scanner(System.in);
    private int rows;
    private int columns;

    public SettingsService() {
    }

    private int getBiggerDimension(int rows, int columns) {
        if (rows > columns) {
            return rows;
        }
        return columns;
    }

    public int getDimensionFromUser(String dimensionName) {
        String userAnswer;
        do {
            outputAPI.printMessageToUserInLine("insertNumberOfDimension");
            outputAPI.printMessage(dimensionName);
            userAnswer = scanner.nextLine();
        } while (!inputApi.validateDimension(userAnswer));
        if (dimensionName.equals("rows")) {
            rows = Integer.valueOf(userAnswer);
        } else {
            columns = Integer.valueOf(userAnswer);
        }
        return Integer.valueOf(userAnswer);
    }

    public int getWiningConditionLengthFromUser() {
        String userAnswer;
        do {
            outputAPI.printMessageToUserNextLine("insertWinningCondition");
            userAnswer = scanner.nextLine();
        } while (!inputApi.validateWiningCondition(userAnswer, getBiggerDimension(rows, columns)));
        return Integer.valueOf(userAnswer);
    }

    public List<Player> getPlayersInfoFromUser() {
        String userAnswerPlayerOneName;
        String userAnswerPlayerTwoName;
        String markerPlayerOne;
        List<Player> players = new ArrayList<>(2);

        do {
            outputAPI.printMessageToUserNextLine("insertNameOf1Player");
            userAnswerPlayerOneName = scanner.nextLine();
        } while (!inputApi.validateName(userAnswerPlayerOneName));

        do {
            outputAPI.printMessageToUserNextLine("insertMarker");
            outputAPI.printMessage(userAnswerPlayerOneName + " (O,X)");
            markerPlayerOne = scanner.nextLine();
        } while (!inputApi.validateMarker(markerPlayerOne));

        do {
            outputAPI.printMessageToUserNextLine("insertNameOf2Player");
            userAnswerPlayerTwoName = scanner.nextLine();
        } while (!inputApi.validateName(userAnswerPlayerTwoName));

        players.add(new Player(userAnswerPlayerOneName, true, getMarkerBasedOnUserAnswer(markerPlayerOne).get(0)));
        players.add(new Player(userAnswerPlayerTwoName, false, getMarkerBasedOnUserAnswer(markerPlayerOne).get(1)));
        return players;
    }

    private List<Marker> getMarkerBasedOnUserAnswer(String markerPlayerOne) {

        List<Marker> markers = new ArrayList<>(2);

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
