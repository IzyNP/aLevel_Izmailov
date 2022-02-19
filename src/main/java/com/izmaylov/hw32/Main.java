package com.izmaylov.hw32;

import com.izmaylov.hw32.workers.Hippodrome;
import com.izmaylov.hw32.workers.Worker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        int numberOfHorses;
        int chosenOne;

        Worker worker =  new Worker();
        worker.doSomething();

        System.out.println("Enter the number of horses: ");
        numberOfHorses = scanner.nextInt();
        System.out.println("Enter the number of horse you have chosen: ");
        chosenOne = scanner.nextInt();

        Hippodrome hippodrome = new Hippodrome(numberOfHorses,chosenOne);
        hippodrome.startRacing();
    }
}
