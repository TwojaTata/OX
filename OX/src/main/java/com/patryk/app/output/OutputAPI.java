package com.patryk.app.output;

import com.patryk.app.Board;
import java.util.Scanner;

/**
 * @author Patryk Kucharski
 *
 * API to provide all the output methods
 * most of which dispaly given message
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

    public void setLanguage(String languageCode, String countryCode) {
        printer.setLanguage(languageCode, countryCode);
    }

    public void printMessage(String message) {
        printer.printMessage(message);
    }

    public void printLanguageMenu() {
        printer.printLanguageMenu();
    }
}
