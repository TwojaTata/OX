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

    public void createMainLoop(){

        String userAnswer;
        do {
            outputAPI.printMenu();
            userAnswer = scanner.nextLine();
            switch (userAnswer){
                case "1":{
                    turnController.doARound(board);
                    board = boardServiceAPI.initializeDefaultBoard();
                    break;
                }
                case "2":{
                    board = boardServiceAPI.initializeDefaultBoard();
                    board = boardServiceAPI.initializeBoardOrResetBoard();//tODO nazwa metody do zmiany
                    break;
                }
                case "3":{
                    outputAPI.setLanguage();
                    break;
                }
                default:{
                    outputAPI.printMessage("no such option");
                    break;
                }
            }
        }while (!userAnswer.toLowerCase().equals("exit"));
    }
}
