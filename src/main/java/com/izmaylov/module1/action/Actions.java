package com.izmaylov.module1.action;

import java.util.Arrays;

public class Actions {
    public void fillTheArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 201) - 100;
        }

    }

    public void descendingSort(int[] array) {
        boolean isSorted = false;
        int temp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]) {
                    isSorted = false;
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }

            }
        }
        System.out.println(Arrays.toString(array));
    }

    public void ascendingSort(int[] array) {
        boolean isSorted = false;
        int temp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    isSorted = false;
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }

            }
        }
        System.out.println(Arrays.toString(array));
    }

    public void everyThirdNumberInCube(int[] array) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (++index == 3) {
                array[i] = (int) Math.pow(array[i], 3);
                index = 0;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
