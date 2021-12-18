package com.izmaylov.hw17.model;

import lombok.Getter;

@Getter
public class Item {
    private final String name;
    private final int cost;

    public Item(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}
