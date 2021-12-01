package com.izmaylov.hw12;

import com.izmaylov.hw12.phoneBook.PhoneBook;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

       /* try {
            MainWithException.main();
            ClassWithTwoMethods.f();
        } catch (Exception e) {
           System.err.println(e.getMessage());
        }

        try{
            ClassThatThrowThreeException.throwEverything();
        }catch (RuntimeException | IOException | Error  e){
            System.err.println("Исключение в " + e.getClass());
        }*/

        PhoneBook phoneBook = new PhoneBook();
        Optional<Integer> tmp = phoneBook.findIndexByPhoneNumber("016/161617");
        System.out.println(phoneBook.findIndexByPhoneNumber("016/161619"));
        tmp.ifPresent(System.out::println);
    }
}
