package com.izmaylov.module1;

import java.util.Arrays;

public class Lock {
    private  final int[] inmutableArray;

    public  Lock(int[] inmutableArray) {
        this.inmutableArray = Arrays.copyOf(inmutableArray,inmutableArray.length);
    }

    public  int[] getInmutableArray() {
        return Arrays.copyOf(inmutableArray, inmutableArray.length);
    }
}
