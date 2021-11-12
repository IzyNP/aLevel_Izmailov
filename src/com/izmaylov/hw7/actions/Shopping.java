package com.izmaylov.hw7.actions;

import com.izmaylov.hw7.model.Animal;
import com.izmaylov.hw7.model.Present;

import java.util.Scanner;

public class Shopping {
    public void action(Animal animal, Scanner scanner){
        final Present present = new Present();
        int costOfPresent;
        System.out.println("Добро пожаловать в магазин. Выберите стоимость подарка(100, 150, 200): ");
        costOfPresent = scanner.nextInt();
        if(animal.getMoney() < 100){
            System.out.println("У вас недостаточно денег для покупки подарка");
        }else {
            switch (costOfPresent) {
                case 100:
                    animal.setPresents(present.addPresent(animal));
                    animal.addHappy(20);
                    animal.addMoney(-100);
                    System.out.println("Вы приобрели подарок за 100, теперь у питомца: " + animal.getMoney());
                    break;
                case 150:
                    if(animal.getMoney() >= 150){
                        animal.setPresents(present.addPresent(animal));
                        animal.addHappy(25);
                        animal.addMoney(-150);
                        System.out.println("Вы приобрели подарок за 150, теперь у питомца: " + animal.getMoney());
                        break;
                    }else {
                        System.out.println("У вас недостаточно денег для покупки подарка за 150");
                        break;
                    }
                case 200:
                    if(animal.getMoney() >= 200){
                        animal.setPresents(present.addPresent(animal));
                        animal.addHappy(30);
                        animal.addMoney(-200);
                        System.out.println("Вы приобрели подарок за 200, теперь у питомца: " + animal.getMoney());
                        break;
                    }else {
                        System.out.println("У вас недостаточно денег для покупки подарка за 200");
                        break;
                    }
            }
        }
    }
}
