package com.pokesim.view;

import com.pokesim.model.entities.AllPokemons;
import com.pokesim.model.entities.Player;
import com.pokesim.model.entities.Pokemon;
import com.pokesim.model.entities.WildPokemons;
import com.pokesim.model.game.CityAction;
import com.pokesim.utils.RandomGenerator;

import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner = new Scanner(System.in);

    public Player startGame() {
        System.out.println("Welcome to the pokesim game!");
        System.out.println("Choose your name:");
        String name = scanner.nextLine();
        System.out.println("Choose starting pokemon:");

        for (int i = 0; i < AllPokemons.starters.size(); i++) {
            System.out.printf("%s. %s\n", i, AllPokemons.starters.get(i).toString());
        }

        int chosenPokemon = scanner.nextInt();

        return new Player(name, AllPokemons.starters.get(chosenPokemon).clone());
    }

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

    public Pokemon battleInfo(WildPokemons wildPokemons, Player currentPlayer) {
        System.out.println("WARNING!!! You have encountered " + wildPokemons);
        System.out.println("Choose your fighter: ");
        for (int i = 0; i < currentPlayer.getPokemons().size(); i++) {
            System.out.printf("%s. %s\n", i, currentPlayer.getPokemons().get(i).toString());
        }
        int choice = scanner.nextInt();
        return currentPlayer.getPokemons().get(choice);
    }

    public void battleInterface(WildPokemons wildPokemons, Pokemon currentPokemon, int turn) {
        if(turn % 2 != 0) {

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
                    int attackValue = new RandomGenerator().getRandomInt(currentPokemon.getAttack() - 3, currentPokemon.getAttack() + 3);
                    wildPokemons.attack(attackValue);
                    System.out.println("zaatakowales za " + attackValue);
                    break;
                case 2:
                    currentPokemon.rest();
                    System.out.println("wyleczyles sie");
                    break;
            }

        }
        else{
            System.out.println("Opponent's Turn: ");
            int random = new RandomGenerator().getRandomInt(0, 100);
            if(random < 30) {
                wildPokemons.rest();
                System.out.println("przeciwnik wyleczyl sie");
            }
            else{
                int attackValue = new RandomGenerator().getRandomInt(wildPokemons.getAttack() - 3, wildPokemons.getAttack() + 3);
                currentPokemon.attack(attackValue);
                System.out.println("przeciwnik zaatakowal za " + attackValue);
            }


        }


    }
}
