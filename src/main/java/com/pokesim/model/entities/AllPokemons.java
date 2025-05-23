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

    private final List<StorePokemon> storePokemons = List.of(
            new StorePokemon("Snorlax", "normal", 460, 100, 20),
            new StorePokemon("Diglet", "Earth", 20, 10, 5)
    );

    public List<Pokemon> getStarters() {
        return starters;
    }

    public List<WildPokemons> getWildPokemons() {
        return wildPokemons;
    }

    public List<StorePokemon> getStorePokemons() {
        return storePokemons;
    }

    public Pokemon getStarter(int index) {
        return starters.get(index);
    }

    public WildPokemons getWildPokemon(int index) {
        return wildPokemons.get(index);
    }
}
