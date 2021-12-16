package com.izmaylov.hw16.utilForCollectionFraemwork;

import org.apache.commons.lang3.time.StopWatch;

import java.util.List;
import java.util.Random;

public class ListWorker {
    private static final StopWatch stopWatch = new StopWatch();
    private static final Random random = new Random();
    public static void fill(List<Integer> list){
        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
    }

    public static void takeRandom(List<Integer> list){
        stopWatch.reset();
        stopWatch.start();
        for (int i = 0; i < 1000000; i++) {
            list.get(random.nextInt(100000));
        }
        stopWatch.stop();
        System.out.print(stopWatch.formatTime());
        //return stopWatch.getTime();
    }
}
