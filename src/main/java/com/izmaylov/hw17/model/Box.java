package com.izmaylov.hw17.model;

import com.izmaylov.hw17.util.Values;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Box {
    private final List<Item> items;

    public Box() {
        this.items = fillBox();
    }

    private  List<Item> fillBox(){
        Random random = new Random(1);
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < random.nextInt(15); i++) {
            items.add(Values.createItem());
        }
        return items;
    }
}
