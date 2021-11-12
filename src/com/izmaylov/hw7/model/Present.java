package com.izmaylov.hw7.model;

import java.util.Random;

public class Present {
    private final String name;

    public Present() {
        this.name = presentName();
    }

    public Present createPresent() {
        return new Present();
    }

    public String presentName() {
        String srt = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < srt.length(); i++) {
            int number = random.nextInt(52);
            stringBuilder.append(srt.charAt(number));
        }
        return stringBuilder.toString();
    }

    public Present[] addPresent(Animal animal) {
        Present[] temp = new Present[animal.getPresents().length + 1];
        if(animal.getPresents().length > 0) {
            for (int i = 0; i < animal.getPresents().length; i++) {
                temp[i] = animal.getPresents()[i];
            }
        }
        temp[temp.length - 1] = createPresent();
        return temp;
    }

    @Override
    public String toString() {
        return name;
    }
}
