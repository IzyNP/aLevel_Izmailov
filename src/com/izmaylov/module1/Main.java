package com.izmaylov.module1;

import com.izmaylov.module1.service.UserInputService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        UserInputService userInputService = new UserInputService();
        int[] array = userInputService.userInputArrayLengthAndArrayWillBeFilled();
        userInputService.userChooseSortingTypeAndEveryThirdNumberWillBeInCube(array);

        Lock lock = new Lock(array);
        lock.getInmutableArray()[0] = 10;
        System.out.println(Arrays.toString(lock.getInmutableArray()));
    }
}
