package com.pokesim.model.entities;

public class StorePokemon extends Pokemon {
    public StorePokemon(String name, String element, int hp, int attack, int price) {
        super(name, element, hp, attack);
        price = price;

    }

}
