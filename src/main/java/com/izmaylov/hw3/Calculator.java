package com.izmaylov.hw3;

import java.util.Scanner;

public class Calculator {

    public  void calc(Scanner scanner) {
        boolean run = true;
        while (run) {
            String operation = getString(scanner);
            if (operation.equals(".")) {
                run = false;
            } else {
                System.out.println("Enter first number: ");
                int firstNumber = getInt(scanner);
                System.out.println("Enter second number: ");
                int secondNumber = getInt(scanner);
                switch (operation) {
                    case "/":
                        if (secondNumber == 0) {
                            System.out.println("Invalid second number.");
                        } else {
                            System.out.println(firstNumber / secondNumber);
                        }
                        break;
                    case "*":
                        System.out.println(firstNumber * secondNumber);
                        break;
                    case "+":
                        System.out.println(firstNumber + secondNumber);
                        break;
                    case "-":
                        System.out.println(firstNumber - secondNumber);
                        break;
                    default:
                        System.out.println("Invalid operation");
                }
            }
        }

    }

    public int sumOfDigits(int number) {
        int sum = 0;
        if(number < 0){
            throw new IllegalArgumentException();
        }
        if (number < 10) {
            return number;
        }
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    private int getInt(Scanner scanner){
        return scanner.nextInt();
    }

    private String getString(Scanner scanner){
        System.out.println("Choose operation (*,/,+,-).Choose '.' for the end of program");
        return scanner.next();
    }
}
