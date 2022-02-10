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
        for (int i = 2; i < number; i++) {
             if(i == 2 ){
                 integers.add(i);
             }else if(i <= 7 && i%2!=0){
                 integers.add(i);
             }else if(i%2!=0 && i%3!=0 && i%5!=0 && i%7!=0){
                 integers.add(i);
             }
        }
        return integers;
    }
}
