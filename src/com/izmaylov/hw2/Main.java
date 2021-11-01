package com.izmaylov.hw2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        triangleArea();
        System.out.println("---------------------------");
        smallestNumber();
        System.out.println("---------------------------");
        evenNumber();
        System.out.println("---------------------------");
        binary(19);
    }

    public static void triangleArea() {
        double height = 10;
        double width = 5;
        double length = 6;
        double area;
        double perimeter = (height + width + length) / 2;
        area = Math.sqrt(perimeter * (perimeter - height) * (perimeter - width) * (perimeter - length));
        System.out.println("Area of a triangle = " + area);
    }

    public static void smallestNumber() {
        Random randomNumber = new Random();
        int[] array = {randomNumber.nextInt(), randomNumber.nextInt(), randomNumber.nextInt()};
        System.out.println("All numbers:");
        for (int i = 0; i < array.length; i++) {
            System.out.println(i + 1 + ". " + array[i] + ";");
        }
        int smallest = Math.abs(array[0]) < Math.abs(array[1]) && Math.abs(array[0]) < Math.abs(array[2]) ? Math.abs(array[0]) :
                Math.abs(array[1]) < Math.abs(array[2]) ? Math.abs(array[1]) : Math.abs(array[2]);
        System.out.println("Smallest number: " + smallest);
    }

    public static void evenNumber() {
        int number = new Random().nextInt();
        System.out.println("Number = " + number);
        String result = number % 2 == 0 ? "This number is even" : "This number is odd";
        System.out.println(result);
    }

    public static void binary(int number){
        String binary = "";
        int remainder;
        do {
            remainder = number%2;
            number /= 2;
            binary += remainder;
        }while (number!= 0);
        char[] reverseString = binary.toCharArray();
        String result = "";
        for (int i = reverseString.length - 1; i >= 0 ; i--) {
            result = result + reverseString[i];
        }
        System.out.println(result);
    }
}
