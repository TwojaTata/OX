package com.patryk.app.output;

import com.patryk.app.Board;
import com.patryk.app.Marker;
import com.patryk.app.Player;

import java.util.List;
import java.util.Scanner;

/**
 * @author Patryk Kucharski
 */
public class OutputAPI {

    private SettingsService settingsService = new SettingsService();
    private Printer printer = new Printer();
    private Scanner scanner = new Scanner(System.in);

    public int getDimensionFromUser(String dimensionName) {
        return settingsService.getDimensionFromUser(dimensionName);
    }

    public int getWiningConditionLengthFromUser() {
        return settingsService.getWiningConditionLengthFromUser();
    }

    public List<Player> getPlayersInfoFromUser() {
        return settingsService.getPlayersInfoFromUser();
    }

    public void printMessage(String message){
        printer.printMessage(message);
    }

    public void printMenu(){
        printer.printMenu();
    }

    public void printCurrentPlayer(Board board){
        printer.printCurrentPlayer(board);
    }

    public String askForRow() {
        printer.askForARow();
        return scanner.nextLine();
    }//TODO to nie tutaj? nie ta klasa? nie ta odpowiedzialność

    public String askForColumn() {
        printer.askForAColumn();
        return scanner.nextLine();
    }

    public void setLanguage() {
        //TODO IMPLEMENT
    }
}
