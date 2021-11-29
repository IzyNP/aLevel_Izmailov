package com.izmaylov.hw12.exceptionClasses;

import java.util.Random;

public class ClassThatThrowThreeException {
    public static void throwEverything() throws ExceptionClass {
        int random = new Random().nextInt(3);
        while (true) {
            if(random == 0){
                throw new ExceptionClass();
            }else if(random == 1){
                throw new ErrorClass();
            }else{
                throw new RuntimeClass();
            }

        }

    }
}
