package com.izmaylov.hw12.exceptionClasses;

import java.io.IOException;

public class ClassWithTwoMethods {
    public static void f() throws Exception {
        try {
            g();
        }catch (IOException e){
            throw new Exception("Исключение в методе f() в классе ClassWithTwoMethods");
        }
    }

    private static void g() throws IOException {
        throw new IOException("Исключение в методе g()в классе ClassWithTwoMethods");
    }
}
