package com.pokesim.model.entities;

public class WildPokemons extends Pokemon {
    public WildPokemons(String name, String element, int hp, int attack) {
        super(name, element, hp, attack);
    }

    @Override
    public void attack(int i) {
        super.attack(i*2);
    }
}
