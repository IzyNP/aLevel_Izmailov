package com.izmaylov.hw31.model;

import lombok.Getter;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
@Getter
public class CountThread extends Thread{
    private final List<Integer> integerList;
    private final List<Integer> integers = new ArrayList<>();

    public CountThread(List<Integer> integerList){
        this.integerList = integerList;
    }

    @Override
    public void run() {
        integers.addAll(integerList);
        System.out.println(Thread.currentThread().getName() + " counted " + integers.size() +  " numbers");
    }

    @SneakyThrows
    public void runner(){
        this.start();
        this.join();
    }
}
