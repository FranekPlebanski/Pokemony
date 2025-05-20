package com.pokesim.utils;

import java.util.Random;

public class RandomGenerator {
    private Random random = new Random();

    public int getRandomInt(int min, int max){
        return random.nextInt((max - min) + 1) + min;
    }
}
