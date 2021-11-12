package com.izmaylov.hw7.actions;

import com.izmaylov.hw7.model.Animal;

public class Feeding {
    public void action(Animal animal){
        animal.addSatiety(5);
        animal.addPurity(-2);
        System.out.println("Вы покормили " + animal.getName() + "\n");
    }
}
