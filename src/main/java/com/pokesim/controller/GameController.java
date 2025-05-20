package com.pokesim.controller;

import com.pokesim.model.entities.Player;
import com.pokesim.model.entities.Pokemon;
import com.pokesim.model.entities.WildPokemons;
import com.pokesim.model.game.BattleAction;
import com.pokesim.model.game.CityAction;
import com.pokesim.model.game.WildPokemonRandomChoice;
import com.pokesim.utils.RandomGenerator;
import com.pokesim.view.ConsoleUI;
import com.pokesim.view.UI;

public class GameController {

    private final UI consoleUI;
    private Player currentPlayer;


    public GameController(UI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public void run() {
        this.currentPlayer = consoleUI.startGame();
        while(true) {
            CityAction action = consoleUI.cityMenu("aaa");
            if (action == CityAction.BUY_POKEMON) {

            } else if (action == CityAction.HEAL) {

            } else if (action == CityAction.FIGHT) {
                WildPokemons wildPokemons = new WildPokemonRandomChoice().getRandomWildPokemon();
                Pokemon chosenOne = consoleUI.battleInfo(wildPokemons, currentPlayer);
                while (wildPokemons.getHp() > 0 && chosenOne.getHp() > 0) {
                    BattleAction choice = consoleUI.battleInterface(wildPokemons, chosenOne);
                    switch (choice) {
                        case FIGHT:
                            int attackValue = new RandomGenerator().getRandomInt(chosenOne.getAttack() - 3, chosenOne.getAttack() + 3);
                            wildPokemons.attack(attackValue);
                            consoleUI.notifyAttackSelf(attackValue);
                            break;
                        case HEAL:
                            chosenOne.rest();
                            consoleUI.notifyRestSelf();
                            break;
                    }

                    consoleUI.opponentTurn();
                    int random = new RandomGenerator().getRandomInt(0, 100);
                    if(random < 30) {
                        wildPokemons.rest();
                        consoleUI.notifyRestOpponent();
                    }
                    else{
                        int attackValue = new RandomGenerator().getRandomInt(wildPokemons.getAttack() - 3, wildPokemons.getAttack() + 3);
                        chosenOne.attack(attackValue);
                        consoleUI.notifyAttackOpponent(attackValue);
                    }

                    if(chosenOne.getHp() <= 0) {
                        currentPlayer.removePokemon(chosenOne);
                    } else if (wildPokemons.getHp() <= 0) {
                        currentPlayer.addPokemon(wildPokemons);
                        consoleUI.notifyCatch(wildPokemons.getName());
                    }
                }

            }



        }
    }
}
