package com.pokesim.app;

import com.pokesim.controller.GameController;
import com.pokesim.view.ConsoleUI;

public class Main {
    public static void main(String[] args) {
        ConsoleUI consoleUI = new ConsoleUI();

        GameController game = new GameController(
                consoleUI
        );

        game.run();
    }
}