package com.izmaylov.hw7.actions;

import com.izmaylov.hw7.model.Animal;

public class Playing {
    private int countOfGames;

    public void action(Animal animal){
        if(countOfGames == 5){
            animal.addAge(1);
            countOfGames = 0;
        }
        GettingSick.testYourLuck(animal);
        animal.addSatiety(-3);
        animal.addHappy(6);
        animal.addMoney(1 + (int)(Math.random() + 10));
        countOfGames++;
        System.out.println("Вы поиграли с " + animal.getName() + "\n");

    }
}
