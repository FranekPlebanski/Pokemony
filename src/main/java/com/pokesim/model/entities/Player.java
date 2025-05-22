package com.pokesim.model.entities;

import com.pokesim.model.world.City;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private List<Pokemon> ownedPokemons = new ArrayList<>();
    private int moneyAmount = 0;
    private String currentCity;

    public Player(String name, Pokemon starter, int moneyAmount, City currentCity) {
        this.name = name;
        ownedPokemons.add(starter);
        this.moneyAmount = moneyAmount;
        this.currentCity = currentCity.getName();
    }

    public int getMoneyAmount() {
        return moneyAmount;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void changeCurrentCity(String newCity) {
        currentCity = newCity;
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
