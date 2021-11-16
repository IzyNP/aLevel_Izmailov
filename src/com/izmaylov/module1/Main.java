package com.izmaylov.module1;

import com.izmaylov.module1.action.Actions;
import com.izmaylov.module1.service.UserInputService;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        UserInputService userInputService = new UserInputService();
        Actions actions = new Actions();
        int[] array = userInputService.userInputArrayLengthAndArrayWillBeFilled();
        userInputService.userChooseSortingType(array);
        actions.everyThirdNumberInCube(array);

        Lock lock = new Lock(array);
        lock.getInmutableArray()[0] = 10;
        System.out.println(Arrays.toString(lock.getInmutableArray()));
    }
}
