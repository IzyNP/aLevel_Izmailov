package com.izmaylov.hw7.service;

import com.izmaylov.hw7.actions.*;
import com.izmaylov.hw7.model.Animal;
import com.izmaylov.hw7.model.AnimalType;

import java.util.Scanner;

public class UserInputService {
    private  final Scanner scanner = new Scanner(System.in);
    private final Feeding feeding = new Feeding();
    private final Healing healing = new Healing();
    private final Playing playing = new Playing();
    private final Shopping shopping = new Shopping();
    private final Working working = new Working();


    public Animal userInputAnimalTypeAndName() {
        System.out.println("Доступные типы персонажа");
        final AnimalType[] values = AnimalType.values();
        StringBuilder animalTypeString = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            animalTypeString.append(i).append(") ").append(values[i]).append("\n");
        }
        System.out.println(animalTypeString);
        int userInputAnimalType;
        do {
            System.out.println("Введите номер животного: ");
            userInputAnimalType = scanner.nextInt();
        } while (userInputAnimalType < 0 || userInputAnimalType >= values.length);

        String userInputAnimalName;
        do {
            System.out.println("Введите имя животного: ");
            userInputAnimalName = scanner.next();
        } while (userInputAnimalName.length() < 3 || userInputAnimalName.length() > 20);

        return new Animal(values[userInputAnimalType], userInputAnimalName);
    }

    public void doAction(Animal animal){
        int userAction;
        boolean resumeAction = true;
        final ActionsMenu[] actionsMenu = ActionsMenu.values();
        do{
            System.out.println("Выберите действие");
            for (int i = 0; i < actionsMenu.length; i++) {
                System.out.println(i + ") " + actionsMenu[i]);

            }
            userAction = scanner.nextInt();
            switch (userAction){
                case 0:
                    feeding.action(animal);
                    continue;
                case 1:
                    playing.action(animal);
                    continue;
                case 2:
                    shopping.action(animal, scanner );
                    continue;
                case 3:
                    working.action(animal);
                    continue;
                case 4:
                    healing.action(animal);
                    continue;
                case 5:
                    System.out.println(animal);
                    continue;
                case 6:
                    animal.showPresents();
                    continue;
                case 7:
                    resumeAction = false;
                    break;
            }
        }while (resumeAction);
    }
}
