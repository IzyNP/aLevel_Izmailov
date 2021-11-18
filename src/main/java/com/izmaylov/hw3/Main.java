package com.izmaylov.hw3;

import java.util.Scanner;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        calculator.calc(scanner);
        calculator.sumOfDigits(scanner.nextInt());
//        countSim();
//        testYourLuck();
//        wordsCount();
//        luckyTickets();
    }

    private static void countSim() {
        int count = 0;
        for (int hour = 0; hour < 23; hour++) {
            String hours = hour < 10 ? "0" + hour : String.valueOf(hour);

            for (int min = 0; min < 59; min++) {
                String minutes = min < 10 ? "0" + min : String.valueOf(min);
                if (hours.equals(minutes)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void testYourLuck() {
        int secret = 1 + (int) (Math.random() * 10);
        boolean check = true;
        System.out.println("Enter your number");
        do {
            int guess = scanner.nextInt();
            if (guess > secret) {
                System.out.println("Много");
            } else if (guess < secret) {
                System.out.println("Мало");
            } else {
                System.out.println("Угадал");
                check = false;
            }
        } while (check);
    }

    private static void wordsCount() {
        System.out.println("Write string: ");
        String someString = scanner.nextLine();
        String[] split = someString.split(" ");
        int count = 0;
        for (String s : split) {
            if (s.trim().isEmpty()) {
                continue;
            }
            count++;
            System.out.println(count);
        }
    }

    private static int sumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    private static void luckyTickets() {
        int count = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 1; j < 1000; j++) {
                if (sumOfDigits(i) == sumOfDigits(j)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
