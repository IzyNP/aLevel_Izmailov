package com.izmaylov.hw32.workers;

import com.izmaylov.hw32.concreteThreads.Horse;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Hippodrome{
    private final int numberOfHorses;
    int chosenOne;
    List<Horse> horses  = new ArrayList<>();
    public Hippodrome(int numberOfHorses, int chosenOne) {
        this.numberOfHorses = numberOfHorses;
        this.chosenOne = chosenOne;
    }

    public void startRacing(){
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfHorses);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(numberOfHorses);

        for (int i = 0; i < numberOfHorses; i++) {
             horses.add(new Horse(i+1,chosenOne,cyclicBarrier));

        }

        for (int i = 0; i < numberOfHorses; i++) {
             executorService.execute(new Horse(i + 1,chosenOne, cyclicBarrier));
        }
        executorService.shutdown();
    }




}
