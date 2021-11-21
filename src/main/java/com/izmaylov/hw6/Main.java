package com.izmaylov.hw6;

public class Main {
    public static void main(String[] args) {
        Car bmw = new Car(Manufacturer.BMW, new Engine(200, EngineType.GAS),"Чёрный");
        Car ford = new Car(Manufacturer.FORD, new Engine(200, EngineType.DIESEL),"Синий");
        Car tesla = new Car(Manufacturer.TESLA, new Engine(200, EngineType.ELECTICAL),"Белый");


    }
}
