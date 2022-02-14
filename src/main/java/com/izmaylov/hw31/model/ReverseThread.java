package com.izmaylov.hw31.model;

public class ReverseThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from thread " + Thread.currentThread().getName());
    }


}
