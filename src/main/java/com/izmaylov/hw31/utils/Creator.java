package com.izmaylov.hw31.utils;

import com.izmaylov.hw31.model.ReverseThread;

import java.util.ArrayList;
import java.util.List;

public class Creator {

    public static List<Thread> createListOfReverseThreads(int number){
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            threads.add(new ReverseThread());
        }
        return threads;
    }

    public static List<Integer> createListOfPrimeNumbers(int number){
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < number; i++) {
             integers.add(i);
        }
        return integers;
    }
}
