package com.pokesim.controller;

import com.pokesim.model.entities.*;
import com.pokesim.model.game.BattleAction;
import com.pokesim.model.game.CityAction;
import com.pokesim.model.game.WildPokemonRandomChoice;
import com.pokesim.model.store.PokemonStore;
import com.pokesim.utils.RandomGenerator;
import com.pokesim.view.ConsoleUI;
import com.pokesim.view.UI;

public class GameController {

    private final UI consoleUI;
    private Player currentPlayer;
    private AllPokemons allPokemons;


    public GameController(UI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public void run() {
        this.currentPlayer = consoleUI.startGame();
        while(currentPlayer.getPokemons().size() < 10 || !currentPlayer.getPokemons().isEmpty()) {
            CityAction action = consoleUI.cityMenu(currentPlayer.getCurrentCity());
            if (action == CityAction.BUY_POKEMON) {

                consoleUI.displayMoneyAmount(currentPlayer);
                StorePokemon pokemonToBuy = consoleUI.getStoreMenu();
                if(pokemonToBuy.getPrice() > currentPlayer.getMoneyAmount()){
                    System.out.println("not bought");  // temp
                }
                else{
                    System.out.println("bought");
                }




            }
            else if (action == CityAction.HEAL) {

                currentPlayer.cityPokemonHeal();
                consoleUI.notifyCityHeal();


            }
            else if (action == CityAction.FIGHT) {
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
                        consoleUI.notifyLosePokemon(chosenOne);
                    } else if (wildPokemons.getHp() <= 0) {
                        currentPlayer.addPokemon(wildPokemons);
                        consoleUI.notifyCatch(wildPokemons.getName());
                        currentPlayer.winBattleMoney();
                    }
                }
                wildPokemons.setDefaultHp();

            }

            if(currentPlayer.getCurrentCity() == "Jonto") {
                currentPlayer.changeCurrentCity("Honto");
            }
            else if(currentPlayer.getCurrentCity() == "Honto") {
                currentPlayer.changeCurrentCity("Ponto");
            }
            else{
                currentPlayer.changeCurrentCity("Jonto");
            }



        }
    }
}
