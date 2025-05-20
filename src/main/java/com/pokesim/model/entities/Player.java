package com.pokesim.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Pokemon> ownedPokemons = new ArrayList<>();
    private int moneyAmmount = 0;

    public Player(String name) {
        this.name = name;
    }

    public void chooseStarter(Pokemon starter) {
        ownedPokemons.add(starter);
    }

    public void addPokemon(Pokemon p) {
        ownedPokemons.add(p);
    }

    public boolean hasPokemons() {
        return !ownedPokemons.isEmpty();
    }

    public List<Pokemon> getPokemons() {
        return ownedPokemons;
    }

    public String getName() {
        return name;
    }
}
