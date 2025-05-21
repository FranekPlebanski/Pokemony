package com.pokesim.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Pokemon> ownedPokemons = new ArrayList<>();
    private int moneyAmount = 0;

    public Player(String name, Pokemon starter, int moneyAmount) {
        this.name = name;
        ownedPokemons.add(starter);
        this.moneyAmount = moneyAmount;
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public void winBattleMoney(){
        this.moneyAmount += 5;
    }


    public void addPokemon(Pokemon pokemon) {
        ownedPokemons.add(pokemon);
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

    public void cityPokemonHeal(){
        for(int i = 0; i <= ownedPokemons.size() - 1; i++){
            ownedPokemons.get(i).cityPokemonHeal();
        }
    }

    public String getName() {
        return name;
    }
}
