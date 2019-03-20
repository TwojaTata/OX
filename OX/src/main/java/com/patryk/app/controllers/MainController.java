package com.patryk.app.controllers;

import com.patryk.app.Board;
import com.patryk.app.gameLogic.BoardService;
import com.patryk.app.gameLogic.BoardServiceAPI;
import com.patryk.app.output.OutputAPI;

import java.util.Scanner;

/**
 * @author Patryk Kucharski
 */
public class MainController {

    OutputAPI outputAPI = new OutputAPI();
    BoardServiceAPI boardServiceAPI = new BoardServiceAPI();
    String userAnswer;
    Scanner scanner = new Scanner(System.in);
    TurnController turnController = new TurnController();

    public void createMainLoop(){

        do {
            outputAPI.printMenu();
            userAnswer = scanner.nextLine();

            switch (userAnswer){
                case "1":{
                    turnController.doARound(boardServiceAPI.initializeDefaultBoard());
                }
                case "2":{
                    boardServiceAPI.initializeBoardOrResetBoard();
                }
                case "3":{
                    boardServiceAPI.initializeBoardOrResetBoard();
                }
                case "4":{
                    //TODO languageService
                }
                default:{
                    outputAPI.printMessage("no such option");
                }
            }
        }while (!userAnswer.equals("exit"));
    }
}
