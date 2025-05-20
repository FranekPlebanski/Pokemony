package com.pokesim.model.game;

import com.pokesim.model.entities.AllPokemons;
import com.pokesim.model.entities.Pokemon;

public class StarterChoice {
    private AllPokemons allPokemons = new AllPokemons();

    public Pokemon selectStarter(int choice){
        return allPokemons.getStarter(choice - 1);
    }
}
