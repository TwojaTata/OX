package com.patryk.app;

import com.patryk.app.controllers.MainController;

/**
 * @author Patryk Kucharski
 */
public class Game {

    MainController mainController = new MainController();

    public void run(){
        mainController.createMainLoop();
    }
}
