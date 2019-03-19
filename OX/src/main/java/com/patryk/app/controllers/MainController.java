package com.patryk.app.controllers;

import com.patryk.app.services.BoardService;
import com.patryk.app.services.SettingsService;

/**
 * @author Patryk Kucharski
 */
public class MainController {

    BoardService boardService = new BoardService();

    public void setUpGame(){
    boardService.setBoardConfigAndInitializeBoard();
    boardService.displayPlayersInfo();
    boardService.displayBoard();
    }

}
