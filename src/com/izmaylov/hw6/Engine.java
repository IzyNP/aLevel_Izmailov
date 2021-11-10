package com.izmaylov.hw6;

public class Engine {
    private int power;
    private EngineType engineType;

    public Engine(int power, EngineType engineType) {
        this.power = power;
        this.engineType = engineType;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public int getPower() {
        return power;
    }
}
