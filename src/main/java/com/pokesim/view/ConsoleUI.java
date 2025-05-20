package com.pokesim.view;

import com.pokesim.model.entities.AllPokemons;
import com.pokesim.model.entities.Player;

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
}
