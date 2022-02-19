package com.izmaylov.hw32.concreteThreads;

import lombok.Getter;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Getter
public class Horse implements Runnable {
    private final int id;
    private final CyclicBarrier cyclicBarrier;
    private int chosenOne;
    private static  int position = 0;
    Random random = new Random(1);

    public Horse(int id, int chosenOne, CyclicBarrier cyclicBarrier) {
        this.id = id;
        this.chosenOne  = chosenOne;
        this.cyclicBarrier = cyclicBarrier;
    }


    @Override
    public void run() {
        int allDistance = 1000;
        int horseDistance = 0;

        do {
            horseDistance += random.nextInt(100) % 2 == 0 ? 100 : 200;
            try {
                Thread.sleep(random.nextInt(20) % 2 == 0 ? 400 : 500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (horseDistance <= allDistance);

        if(horseDistance >= allDistance){
            ++position;
            if(this.id == chosenOne){
                System.out.println("Horse number " + chosenOne + " end racing at " + position + " position");
            }
        }


        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
