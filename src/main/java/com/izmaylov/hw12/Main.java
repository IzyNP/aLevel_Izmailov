package com.izmaylov.hw12;

import com.izmaylov.hw12.phoneBook.PhoneBook;

public class Main {
    public static void main(String[] args) {

        /*try {
            MainWithException.main();
            ClassWithTwoMethods.f();
        } catch (Exception e) {
           System.err.println(e.getMessage());
        }*/

        /*try{
            ClassThatThrowThreeException.throwEverything();
        }catch (Throwable e){
            System.err.println("Исключение в " + e.getClass());
        }*/

        PhoneBook phoneBook = new PhoneBook();
        System.out.println(phoneBook.findIndexByPhoneNumber("016/161619"));
        System.out.println(phoneBook.findIndexByPhoneNumber("016/161617"));
    }
}
