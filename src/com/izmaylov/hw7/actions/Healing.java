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
            System.out.println("Чистота питомца теперь равна: " + animal.getPurity());
            System.out.println("Счастье питомца теперь равно: " + animal.getHappy());
            System.out.println("Сытость питомца теперь равна: " + animal.getSatiety());
        }else {
            System.out.println(animal.getName() + " не требуется в лечении");
        }
    }
}
