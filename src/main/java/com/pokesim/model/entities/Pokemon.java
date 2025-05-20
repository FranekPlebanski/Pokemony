package com.pokesim.model.entities;

public class Pokemon implements Cloneable {
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

    public Pokemon clone() {
        try {
            return (Pokemon) super.clone();

        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
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

    public void attack(int i){
        this.hp -= i;
    }

    public void rest(){
        this.hp += 10;
    }

    public int getAttack() {
        return attack;
    }

    public void setDefaultHp(){
        this.hp += 50;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", element='" + element + '\'' +
                ", hp=" + hp +
                ", attack=" + attack +
                '}';
    }
}
