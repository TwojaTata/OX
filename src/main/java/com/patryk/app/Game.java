package com.patryk.app;

import com.patryk.app.controllers.MainController;

/**
 * @author Patryk Kucharski
 *
 * Main class to run others
 */
public class Game {

    private MainController mainController = new MainController();

    public void run(){
        mainController.createMainLoop();
    }
}
