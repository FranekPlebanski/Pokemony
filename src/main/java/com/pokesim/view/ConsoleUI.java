package com.pokesim.view;

import com.pokesim.model.entities.AllPokemons;
import com.pokesim.model.entities.Player;
import com.pokesim.model.entities.Pokemon;
import com.pokesim.model.entities.WildPokemons;
import com.pokesim.model.game.BattleAction;
import com.pokesim.model.game.CityAction;

import java.util.Scanner;

public class ConsoleUI implements UI {
    private final Scanner scanner = new Scanner(System.in);
    AllPokemons allPokemons = new AllPokemons();

    @Override
    public Player startGame() {
        System.out.println("Welcome to the pokesim game!");
        System.out.println("Choose your name:");
        String name = scanner.nextLine();
        System.out.println("Choose starting pokemon:");

        for (int i = 0; i < AllPokemons.starters.size(); i++) {
            System.out.printf("%s. %s\n", i, AllPokemons.starters.get(i).toString());
        }

        int chosenPokemon = scanner.nextInt();

        return new Player(name, AllPokemons.starters.get(chosenPokemon).clone(), 0);
    }

    @Override
    public CityAction cityMenu(String city){
        while(true) {


            System.out.println("Welcome to the " + city);
            System.out.println("1. Go on road");
            System.out.println("2. Heal pokemons");
            System.out.println("3. Buy pokemons");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    return CityAction.FIGHT;
                case 2:
                    return CityAction.HEAL;
                case 3:
                    return CityAction.BUY_POKEMON;
                default:
                    continue;
            }
        }
    }



    @Override
    public Pokemon battleInfo(WildPokemons wildPokemons, Player currentPlayer) {

        System.out.println("WARNING!!! You have encountered " + wildPokemons);
        System.out.println("Choose your fighter: ");
        for (int i = 0; i < currentPlayer.getPokemons().size(); i++) {
            System.out.printf("%s. %s\n", i, currentPlayer.getPokemons().get(i).toString());
        }
        int choice = scanner.nextInt();
        return currentPlayer.getPokemons().get(choice);
    }

    @Override
    public BattleAction battleInterface(WildPokemons wildPokemons, Pokemon currentPokemon) {
        while(true) {


            System.out.println("Your Pokemon: ");
            System.out.println(currentPokemon.getName());
            System.out.println("Current hp: " + currentPokemon.getHp());
            System.out.println("Current attack: " + currentPokemon.getAttack());

            System.out.println("Enemy pokemon: ");
            System.out.println(wildPokemons.getName());
            System.out.println("Current hp: " + wildPokemons.getHp());
            System.out.println("Current attack: " + wildPokemons.getAttack());

            System.out.println("Choose your action: ");
            System.out.println("1. Attack pokemon (" + (currentPokemon.getAttack() - 3) + "-" + (currentPokemon.getAttack() + 3) + ")");
            System.out.println("2. Rest pokemon (+ 10hp)");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    return BattleAction.FIGHT;
                case 2:
                    return BattleAction.HEAL;
                default:
                    System.out.println("Wrong choice!");
                    continue;
            }
        }

    }

    @Override
    public void notifyAttackSelf(int attackValue){
        System.out.println("You've attacked opponent for " + attackValue + " damage!");
    }

    @Override
    public void notifyRestSelf(){
        System.out.println("You've rested and restored 10 hp points");
    }

    @Override
    public void notifyAttackOpponent(int attackValue){
        System.out.println("Opponent attacked you for " + attackValue + " damage!");

    }

    @Override
    public void notifyCatch(String pokemonName){
        System.out.println("You've caught " + pokemonName);
    }

    @Override
    public void notifyLosePokemon(Pokemon pokemon){
        System.out.println("You've lost pokemon " + pokemon.getName());
    }


    @Override
    public void notifyRestOpponent(){
        System.out.println("Opponent has rested and restored 10 hp points");
    }

    @Override
    public void opponentTurn(){
        System.out.println("Opponent's turn!");
    }

    @Override
    public void notifyCityHeal(){
        System.out.println("You've healed all your pokemons!");
    }

    @Override
    public void getStoreMenu(){
        for (int i = 0; i < allPokemons.getStorePokemons().size(); i++) {
            System.out.println(allPokemons.getStorePokemons().get(i));
        }
    }

    @Override
    public void displayMoneyAmount(Player currentPlayer){
        System.out.println("Your balance: " + currentPlayer.getMoneyAmount());
    }
}
