package com.izmaylov.hw32.workers;

import com.izmaylov.hw32.concreteThreads.ExecutorThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Worker {

    public void doSomething(){
        Thread thread = new ExecutorThread();

        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executorService.execute(thread);
        }
        executorService.shutdown();


        System.out.println(ExecutorThread.getCounter());

    }

}
