package com.izmaylov.hw7.actions;

import com.izmaylov.hw7.model.Animal;

public class Working {

    private int countOfWorking;
    private final GettingSick gettingSick = new GettingSick();

    public void action(Animal animal) {
        if (animal.getAge() >= 5) {
            if (countOfWorking == 6) {
                animal.addAge(1);
                countOfWorking = 0;
            }
            gettingSick.testYourLuck(animal);
            animal.addSatiety(-4);
            animal.addHappy(-2);
            animal.addMoney(5 + (int) (Math.random() + 11));
            System.out.println(animal.getName() + " поработал" + "\n");
            System.out.println("Сытость питомца понизилась, теперь она равна: " + animal.getSatiety());
            System.out.println("Счастье питомца понизилось, теперь оно равна: " + animal.getHappy());
            System.out.println("Ваш питомец получил деньги, теперь у него: " + animal.getMoney());
        } else if(animal.getHappy() < 20){
            System.out.println(animal.getName() + " слишком несчастеный и потому не может работать" + "\n");
        }else {
            System.out.println("Работать можно с 5 лет, а пока что рано." + "\n");
        }
    }
}
