package com.izmaylov.module2.exception;

public class InvalidString extends Exception {

    @Override
    public String getMessage() {
        return "Некорректная строка";
    }
}
