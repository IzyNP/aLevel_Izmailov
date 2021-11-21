package com.izmaylov.hw4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //randomArray();
        //maxNumber();
        //oddNumber();
        //subsequence();
        //twoArrays();
        //userArray();
    }

    private static void randomArray() {
        int[] array = new int[20];
        Random randomNumber = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = randomNumber.nextInt();
            System.out.println(i + 1 + " array number = " + array[i]);
        }
    }

    private static void maxNumber() {
        int[] array = new int[12];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (30 + 1)) - 15;
        }
        int max = array[0];
        int index = 0;
        System.out.println(Arrays.toString(array));
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                index = i;
            }
        }

        System.out.println("Max number in array " + max + ", his position: " + index);
    }

    private static void oddNumber() {
        int[] array = new int[8];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1 + (int) (Math.random() * 10);
        }
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                array[i] = 0;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    private static void subsequence() {
        int[] array = new int[4];
        boolean subsequence = true;

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 90) + 10;
        }
        System.out.println(Arrays.toString(array));

        for (int i = 1; i < array.length; i++) {
            if (array[i] <= array[i - 1]) {
                subsequence = false;
                break;
            }
        }
        if (subsequence) {
            System.out.println("Ascending subsequence");
        } else  {
            System.out.println("Not ascending subsequence");
        }
    }

    private static void twoArrays() {
        int[] firstArray = new int[5];
        int[] secondArray = new int[5];
        for (int i = 0; i < secondArray.length; i++) {
            firstArray[i] = (int) (Math.random() * 6);
            secondArray[i] = (int) (Math.random() * 6);
        }
        System.out.println(Arrays.toString(firstArray));
        System.out.println(Arrays.toString(secondArray));
        double firstResult = 0;
        double secondResult = 0;
        for (int i = 0; i < secondArray.length; i++) {
            firstResult += firstArray[i];
            secondResult += secondArray[i];
        }
        double firstAverage = firstResult / firstArray.length;
        double secondAverage = secondResult / secondArray.length;

        if (firstAverage > secondAverage) {
            System.out.println("Average number for first array is greater");
        } else if (firstAverage < secondAverage) {
            System.out.println("Average number for first array is greater");
        } else {
            System.out.println("They are equal");
        }
    }

    private static void userArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter array length, number must be bigger than 3:");
        int input;
        while (true) {
            input = scanner.nextInt();
            if (input <= 3) {
                System.out.println("Please enter number bigger than 3");
            } else {
                break;
            }
        }
        int[] array = new int[input];
        int evenNumbers = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * ++input);
            if (array[i] % 2 == 0) {
                evenNumbers++;
            }
        }
        System.out.println(Arrays.toString(array));
        int[] evenNumbersArray = new int[evenNumbers];
        int temp = 0;
        for (int j : array) {
            if (j % 2 == 0) {
                evenNumbersArray[temp] = j;
                temp++;
            }
        }
        System.out.println(Arrays.toString(evenNumbersArray));
    }


}



