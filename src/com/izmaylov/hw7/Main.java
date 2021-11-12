package com.izmaylov.hw7;

import com.izmaylov.hw7.model.Animal;
import com.izmaylov.hw7.service.UserInputService;

public class Main {
    public static void main(String[] args) {
        UserInputService userInputService = new UserInputService();
        Animal animal = userInputService.userInputAnimalTypeAndName();
        userInputService.doAction(animal);

    }
}
