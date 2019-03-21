package com.patryk.app.output;

import com.patryk.app.Board;
import com.patryk.app.Player;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @author Patryk Kucharski
 */
public class OutputAPI {


    private Printer printer;
    private Scanner scanner;


    public OutputAPI() {
        this.printer = new Printer();
        this.scanner = new Scanner(System.in);

    }


    public void printMessageToUserNextLine(String key) {
        printer.printMessageToUserNextLine(key);
    }

    public void printMessageToUserInLine(String key) {
        printer.printMessageToUserInLine(key);
    }

    public void printMenu() {
        printer.printMenu();
    }

    public void printCurrentPlayer(Board board) {
        printer.printCurrentPlayer(board);
    }

    public String askForRow() {
        printer.printMessageToUserNextLine("insertRowNumber");
        return scanner.nextLine();
    }

    public String askForColumn() {
        printer.printMessageToUserNextLine("insertColumnNumber");
        return scanner.nextLine();
    }
    public void setLanguage(String languageCode, String countryCode){
        printer.setLanguage(languageCode, countryCode);
    }

//    public void setLanguageVersion(String languageCode, String countryCode) {
//        languageService.setLanguageVersion(languageCode, countryCode);
//    }

//    public ResourceBundle getResourceBundleInstance() {
//        return languageService.getResourceBundleInstance();
//    }

    public void printMessage(String message) {
        printer.printMessage(message);
    }

    public void printLanguageMenu() {
        printer.printLanguageMenu();
    }
}
