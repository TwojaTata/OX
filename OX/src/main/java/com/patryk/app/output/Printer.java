package com.patryk.app.output;

import com.patryk.app.Board;

/**
 * @author Patryk Kucharski
 */
public class Printer {

    void printMessage(String message){
        System.out.println(message);
    }

    void printMenu() {
        System.out.println("Welcome to TicTacToe");
        System.out.println("Choose number of following options");
        System.out.println("1. Play");
        System.out.println("2. Configure settings");
        System.out.println("3. Configure players");
        System.out.println("4. Configure language");
        System.out.println("5. Exit");

    }

    void printCurrentPlayer(Board board){
        //TODO zaimplementiować
    }
}
