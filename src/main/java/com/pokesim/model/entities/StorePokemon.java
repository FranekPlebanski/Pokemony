package com.pokesim.model.entities;

public class StorePokemon extends Pokemon {

    private int price;

    public StorePokemon(String name, String element, int hp, int attack, int price) {
        super(name, element, hp, attack);
        this.price = price;

    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + getName() + '\'' +
                ", element='" + getElement() + '\'' +
                ", hp=" + getHp() +
                ", attack=" + getAttack() + ", price= " + price +
                '}';
    }

}
