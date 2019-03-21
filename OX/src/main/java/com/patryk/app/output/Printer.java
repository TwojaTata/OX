package com.patryk.app.output;

import com.patryk.app.Board;
import com.patryk.app.Player;

import java.util.stream.Collectors;

/**
 * @author Patryk Kucharski
 *
 * Helds basic display methods
 *
 */
class Printer {

    private LanguageService languageService = new LanguageService();

    void printMessageToUserNextLine(String key) {
        System.out.println(languageService.getResourceBundleInstance().getString(key));
    }

    void printMessageToUserInLine(String key) {
        System.out.print(languageService.getResourceBundleInstance().getString(key));
    }

    void printMessage(String message){
        System.out.println(message);
    }

    void printMenu() {

        printMessageToUserNextLine("chooseOption");
        printMessageToUserNextLine("option1Play");
        printMessageToUserNextLine("option2ConfigureSettings");
        printMessageToUserNextLine("option3SetLanguage");
        printMessageToUserNextLine("exitToCloseTheGame");
    }

    void printCurrentPlayer(Board board){

        System.out.println(board.players.stream()
                .filter(Player::hasTurn)
                .collect(Collectors.toList())
                .get(0).toString());
    }

    void printLanguageMenu() {

        printMessageToUserNextLine("chooseLanguage");
        printMessageToUserNextLine("english");
        printMessageToUserNextLine("polish");
        printMessageToUserNextLine("typeExitToQuitSettings");
    }

    void setLanguage(String languageCode, String countryCode) {
        languageService.setLanguageVersion(languageCode,countryCode);
    }
}
