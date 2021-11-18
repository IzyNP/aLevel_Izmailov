package com.izmaylov.hw6;

public enum Manufacturer {
    FORD("Форд"), BMW("БМВ"),TESLA("Тесла");

    private String russianName;

    Manufacturer(String name){
        russianName = name;
    }

    public String getRussianName() {
        return russianName;
    }
}
