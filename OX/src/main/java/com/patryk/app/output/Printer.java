package com.patryk.app.output;

import com.patryk.app.Board;
import com.patryk.app.Player;

import java.util.stream.Collectors;

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
        System.out.println("4. Exit");

    }

    void printCurrentPlayer(Board board){

        System.out.println(board.players.stream()
                .filter(Player::hasTurn)
                .collect(Collectors.toList())
                .get(0).toString());

    }

    void askForAColumn() {
        System.out.println("insert column number");
    }


    void askForARow() {
        System.out.println("insert row number");
    }
}
