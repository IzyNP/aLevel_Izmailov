package com.izmaylov.hw11.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Contact {
    private final String name;
    private int number;

    public Contact(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Имя: " + name + "\n" +"Номер телефона: " + number;
    }
}
