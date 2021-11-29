package com.izmaylov.hw12.exceptionClasses;

public class MainWithException {
    public static void main() throws Exception{
        try{
            throw new Exception("Метод main() в классе MainWithException выбросил исключение.");
        }catch (Exception e){
            System.err.println(e.getMessage());
        }finally {
            System.out.println("Мы были здесь.");
        }
    }
}
