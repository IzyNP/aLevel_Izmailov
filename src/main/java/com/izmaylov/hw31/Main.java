package com.izmaylov.hw31;

import com.izmaylov.hw31.model.CountThread;
import com.izmaylov.hw31.utils.Creator;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> list = Creator.createListOfReverseThreads(50);
        List<Integer> integerList = Creator.createListOfPrimeNumbers(100);

        for (int i = (list.size() -1); i > 0; i--) {
            list.get(i).start();
        }

        CountThread countThread = new CountThread(integerList.stream()
                .limit(integerList.size()/2)
                .collect(Collectors.toList()));
        CountThread countThread1 = new CountThread(integerList.stream()
                .skip(integerList.size()/2)
                .collect(Collectors.toList()));


        countThread.start();
        countThread1.start();


       System.out.println("Two threads counted " + (countThread.getIntegerList().size() + countThread1.getIntegerList().size()) + " numbers");
    }
}



