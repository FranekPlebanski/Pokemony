package com.pokesim.model.world;

public class Road {
    private City from;
    private City to;

    public Road(City from, City to) {
        this.from = from;
        this.to = to;
    }

    public City getFrom() {
        return from;
    }

    public City getTo() {
        return to;
    }
}
