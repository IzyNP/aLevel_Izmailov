package com.izmaylov.hw31.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CountThread extends Thread {
    private final List<Integer> integerList;
    private final List<Integer> integers = new ArrayList<>();

    public CountThread(List<Integer> integerList) {
        this.integerList = integerList;
    }

    @Override
    public void run() {
        synchronized (integers) {
            for (int i = 2; i < integerList.size(); i++) {
                if (integerList.get(i) == 2) {
                    integers.add(integerList.get(i));
                } else if (integerList.get(i) <= 7 && integerList.get(i) % 2 != 0) {
                    integers.add(integerList.get(i));
                } else if (integerList.get(i) % 2 != 0 && integerList.get(i) % 3 != 0 && integerList.get(i) % 5 != 0 && integerList.get(i) % 7 != 0) {
                    integers.add(integerList.get(i));
                }
            }
        }
        System.out.println("Prime numbers from " + Thread.currentThread().getName() + " is " + integers);
        System.out.println(Thread.currentThread().getName() + " counted " + integers.size() + " numbers");
    }


}
