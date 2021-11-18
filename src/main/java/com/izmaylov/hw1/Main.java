package com.izmaylov.hw1;

public class Main {
    public static void main(String[] args) {
        String firstName = "Nikita";
        String lastName = "Izmailov";
        System.out.println(firstName + " " + lastName);
        if (firstName.length() > 7) {
            System.out.println("more than 7");
        } else if (firstName.length() < 7) {
            System.out.println("less than 7");
        }
        int value = 5;
        for (int i = 0; i < 10; i++) {
            System.out.println("Step " + i + ", value " + value);
            value += 2;
        }
    }
}

