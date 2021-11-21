package com.izmaylov.hw7.actions;

import com.izmaylov.hw7.model.Animal;

public class Healing {

    public void action(Animal animal){
        if(animal.getMoney() < 50){
            System.out.println("Недостаточно денег для лечения." + "\n");
        }else if(animal.isIll()){
            animal.setPurity(80);
            animal.setHappy(10);
            animal.setSatiety(70);
            animal.setIll(false);
            System.out.println("Вы вылечили " + animal.getName() + "\n");
        }else {
            System.out.println(animal.getName() + " не требуется в лечении");
        }
    }
}
