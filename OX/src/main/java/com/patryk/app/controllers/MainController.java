package com.patryk.app.controllers;

import com.patryk.app.Board;
import com.patryk.app.gameLogic.BoardServiceAPI;
import com.patryk.app.output.OutputAPI;

import java.util.Scanner;

/**
 * @author Patryk Kucharski
 */
public class MainController {

    private OutputAPI outputAPI = new OutputAPI();
    private BoardServiceAPI boardServiceAPI = new BoardServiceAPI();
    private Scanner scanner = new Scanner(System.in);
    private TurnController turnController = new TurnController();
    private Board board = boardServiceAPI.initializeDefaultBoard();
    private String language;
    private boolean isLanguageValid = false;

    public void createMainLoop() {

        String userAnswer;

        outputAPI.printMessageToUserNextLine("welcomeToTheGame");
        do {
            outputAPI.printMenu();
            userAnswer = scanner.nextLine();
            switch (userAnswer) {
                case "1": {
                    turnController.doARound(board);
                    board = boardServiceAPI.initializeDefaultBoard();
                    break;
                }
                case "2": {
                    board = boardServiceAPI.initializeDefaultBoard();
                    board = boardServiceAPI.initializeBoardWithGivenConfig();
                    break;
                }
                case "3": {
                    do {
                        outputAPI.printLanguageMenu();
                        language = scanner.nextLine();
                        if (language.toLowerCase().equals("pl") || language.toLowerCase().equals("eng")) {
                            outputAPI.setLanguage(language.toLowerCase(), language);
                            isLanguageValid = true;
                        }
                    } while (!isLanguageValid);
                    break;
                }
                default: {
                    if (userAnswer.toLowerCase().equals("exit")) {
                        outputAPI.printMessage("Thanks for playing!");
                        break;
                    } else {
                        outputAPI.printMessageToUserNextLine("noSuchOption");
                        break;
                    }
                }
            }
        } while (!userAnswer.toLowerCase().equals("exit"));
    }
}

