package com.pokesim.controller;

import com.pokesim.model.entities.Player;
import com.pokesim.view.ConsoleUI;

public class GameController {

    private final ConsoleUI consoleUI;
    private Player currentPlayer;

    public GameController(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public void run() {
        this.currentPlayer = consoleUI.startGame();
    }
}
