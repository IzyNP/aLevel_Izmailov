package com.izmaylov.hw12.phoneBook;

import lombok.EqualsAndHashCode;

import java.util.Optional;
@EqualsAndHashCode
public class PhoneBook {
    private static final String[] PHONE_BOOK = new String[3];

    public PhoneBook(){
        PHONE_BOOK[0] = "016/161616";
        PHONE_BOOK[1] = "016/161617";
        PHONE_BOOK[2] = "016/161618";
    }

    public Optional<Integer> findIndexByPhoneNumber(String phoneNumber){
        Integer tmp = IterInPhoneBook(phoneNumber);
        if(tmp == null){
            return Optional.empty();
        }
        return Optional.of(tmp);
    }

    private  Integer IterInPhoneBook(String phoneNumber){
        for (int i = 0; i < PHONE_BOOK.length; i++) {
            if(phoneNumber.equals(PHONE_BOOK[i])){
                return i;
            }
        }
        return null;
    }



}
