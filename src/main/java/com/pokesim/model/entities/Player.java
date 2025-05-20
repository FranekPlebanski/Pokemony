package com.pokesim.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Pokemon> pokemons = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void chooseStarter(Pokemon starter) {
        pokemons.add(starter);
    }

    public void addPokemon(Pokemon p) {
        pokemons.add(p);
    }

    public boolean hasPokemons() {
        return !pokemons.isEmpty();
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public String getName() {
        return name;
    }
}
