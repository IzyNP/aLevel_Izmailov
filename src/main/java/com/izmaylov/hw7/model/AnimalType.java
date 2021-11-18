package com.izmaylov.hw7.model;

public enum AnimalType {
    CAT("кошка"), DOG("собака"), DEER("олень"), LION("лев");

    private String type;

    AnimalType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}
