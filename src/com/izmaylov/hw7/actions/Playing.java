package com.izmaylov.hw7.actions;

import com.izmaylov.hw7.model.Animal;

public class Playing {
    private int countOfGames;
    private final GettingSick gettingSick = new GettingSick();

    public void action(Animal animal){
        if(countOfGames == 5){
            animal.addAge(1);
            countOfGames = 0;
            System.out.println("Ваш питомец повзрослел, теперь ему " + animal.getAge());
        }
        gettingSick.testYourLuck(animal);
        animal.addSatiety(-3);
        animal.addHappy(6);
        animal.addMoney(1 + (int)(Math.random() + 10));
        countOfGames++;
        System.out.println("Вы поиграли с " + animal.getName() + "\n");
        System.out.println("Сытость питомца понизилась, теперь она равна: " + animal.getSatiety());
        System.out.println("Счастье питомца увеличилось, теперь оно равна: " + animal.getHappy());
        System.out.println("Ваш питомец получил деньги, теперь у него: " + animal.getMoney());

    }
}
