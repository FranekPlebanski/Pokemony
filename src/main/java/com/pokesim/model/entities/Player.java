package com.pokesim.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Pokemon> ownedPokemons = new ArrayList<>();
    private int moneyAmount = 0;

    public Player(String name, Pokemon starter) {
        this.name = name;
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

    public void removePokemon(Pokemon pokemon){
        ownedPokemons.remove(pokemon);
    }

    public String getName() {
        return name;
    }
}
