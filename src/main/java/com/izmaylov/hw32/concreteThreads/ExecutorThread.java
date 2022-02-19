package com.izmaylov.hw32.concreteThreads;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExecutorThread extends Thread{

    private final Lock lock = new ReentrantLock();
    private static int counter = 50;


    @Override
    public void run() {
        lock.lock();
        counter +=2;
        lock.unlock();
    }

    public static int getCounter() {
        return counter;
    }
}
