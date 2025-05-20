package com.pokesim.model.entities;

public class Pokemon {
    private String name;
    private String element;
    private int hp;
    private int attack;

    public Pokemon(String name, String element, int hp, int attack) {
        this.name = name;
        this.element = element;
        this.hp = hp;
        this.attack = attack;

    }

    public String getName() {
        return name;
    }

    public String getElement() {
        return element;
    }

    public int getHp() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }
}
