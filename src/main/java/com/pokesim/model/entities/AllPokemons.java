package com.pokesim.model.entities;

import java.util.List;

public class AllPokemons {
    public static final List<Pokemon> starters = List.of(
            new Pokemon("Bulbasaur", "Earth", 100, 5),
            new Pokemon("Charmander", "Fire", 90, 10),
            new Pokemon("Squirtle", "Water", 95, 6)
    );

    private final List<WildPokemons> wildPokemons = List.of(
            new WildPokemons("Pidgey", "Air", 50, 4),
            new WildPokemons("Rattata", "Normal", 45, 3),
            new WildPokemons("Zubat", "Poison", 40, 5),
            new WildPokemons("Charmander", "Fire", 70, 12)
    );

    private final List<Pokemon> storePokemons = List.of(

    );

    public List<Pokemon> getStarters() {
        return starters;
    }

    public List<WildPokemons> getWildPokemons() {
        return wildPokemons;
    }

    public Pokemon getStarter(int index) {
        return starters.get(index);
    }

    public WildPokemons getWildPokemon(int index) {
        return wildPokemons.get(index);
    }
}
