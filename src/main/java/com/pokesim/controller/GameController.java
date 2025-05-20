package com.pokesim.controller;

import com.pokesim.model.entities.Player;
import com.pokesim.model.entities.Pokemon;
import com.pokesim.model.entities.WildPokemons;
import com.pokesim.model.game.CityAction;
import com.pokesim.view.ConsoleUI;

public class GameController {

    private final ConsoleUI consoleUI;
    private Player currentPlayer;


    public GameController(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public void run() {
        this.currentPlayer = consoleUI.startGame();
        while(true) {
            CityAction action = consoleUI.cityMenu("aaa");
            if (action == CityAction.BUY_POKEMON) {

            } else if (action == CityAction.HEAL) {

            } else if (action == CityAction.FIGHT) {
                WildPokemons wildPokemons = new WildPokemons("Snorlax", "Normal", 10, 10);
                Pokemon chosenOne = consoleUI.battleInfo(wildPokemons, currentPlayer);
                int turn = 1;
                while (wildPokemons.getHp() > 0 && chosenOne.getHp() > 0) {
                    consoleUI.battleInterface(wildPokemons, chosenOne, turn);
                    turn += 1;
                }
            }
        }
    }
}
