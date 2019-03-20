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
 * Service to get dimensions and wining condition from user
 */
public class SettingsService {

    private InputAPI inputApi = new InputAPI();
    private Scanner scanner = new Scanner(System.in);
    private int rows;
    private int columns;

    SettingsService() {
    }

    /**
     * @param rows
     * @param columns
     * @return biggerDimension
     */
    private int getBiggerDimension(int rows, int columns) {
        if (rows > columns) {
            return rows;
        }
        return columns;
    }

    /**
     * @param dimensionName
     */
    int getDimensionFromUser(String dimensionName) {
        String userAnswer;

        do {
            System.out.println("insert number of " + dimensionName);
            userAnswer = scanner.nextLine();
        } while (!inputApi.validateDimension(userAnswer));
        if (dimensionName.equals("rows")){
            rows = Integer.valueOf(userAnswer);
        }else {
            columns = Integer.valueOf(userAnswer);
        }
        return Integer.valueOf(userAnswer);
    }

    /**
     *
     */

    int getWiningConditionLengthFromUser() {
        String userAnswer;

        do {
            System.out.println("insert number of wining marks in a row");//TODO wymyślić dobre pytanie
            userAnswer = scanner.nextLine();
        } while (!inputApi.validateWiningCondition(userAnswer, getBiggerDimension(rows, columns)));
        return Integer.valueOf(userAnswer);
    }

    List<Player> getPlayersInfoFromUser() {
        String userAnswerPlayerOneName;
        String userAnswerPlayerTwoName;
        String markerPlayerOne;
        List<Player> players = new ArrayList<>(2);

        do {
            System.out.println("Insert name of player to begin");
            userAnswerPlayerOneName = scanner.nextLine();
        } while (!inputApi.validateName(userAnswerPlayerOneName));

        do {
            System.out.println("Insert marker of " + userAnswerPlayerOneName + " (O,X)");
            markerPlayerOne = scanner.nextLine();
        } while (!inputApi.validateMarker(markerPlayerOne));

        do {
            System.out.println("Insert name of second player");
            userAnswerPlayerTwoName = scanner.nextLine();
        } while (!inputApi.validateName(userAnswerPlayerTwoName));

        players.add(new Player(userAnswerPlayerOneName, true, getMarkerBasedOnUserAnswer(markerPlayerOne).get(0)));
        players.add(new Player(userAnswerPlayerTwoName, false, getMarkerBasedOnUserAnswer(markerPlayerOne).get(1)));
        return players;
    }

    private List<Marker> getMarkerBasedOnUserAnswer(String markerPlayerOne) {

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
