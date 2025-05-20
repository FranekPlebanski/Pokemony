package com.pokesim.view;

import com.pokesim.model.entities.Player;
import com.pokesim.model.entities.Pokemon;
import com.pokesim.model.entities.WildPokemons;
import com.pokesim.model.game.BattleAction;
import com.pokesim.model.game.CityAction;

public interface UI {
    Player startGame();

    CityAction cityMenu(String city);

    Pokemon battleInfo(WildPokemons wildPokemons, Player currentPlayer);

    BattleAction battleInterface(WildPokemons wildPokemons, Pokemon currentPokemon);

    void notifyAttackSelf(int attackValue);

    void notifyRestSelf();

    void notifyAttackOpponent(int attackValue);

    void notifyRestOpponent();

    void opponentTurn();
}
