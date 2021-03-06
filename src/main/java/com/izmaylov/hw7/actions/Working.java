package com.izmaylov.hw7.actions;

import com.izmaylov.hw7.model.Animal;

public class Working {

    private int countOfWorking;

    public void action(Animal animal) {
        if (animal.getAge() >= 5) {
            if (countOfWorking == 6) {
                animal.addAge(1);
                countOfWorking = 0;
            }
            GettingSick.testYourLuck(animal);
            animal.addSatiety(-4);
            animal.addHappy(-2);
            animal.addMoney(5 + (int) (Math.random() + 11));
            System.out.println(animal.getName() + " поработал" + "\n");
            countOfWorking++;
        } else if(animal.getHappy() < 20){
            System.out.println(animal.getName() + " слишком несчастеный и потому не может работать" + "\n");
        }else {
            System.out.println("Работать можно с 5 лет, а пока что рано." + "\n");
        }
    }
}
