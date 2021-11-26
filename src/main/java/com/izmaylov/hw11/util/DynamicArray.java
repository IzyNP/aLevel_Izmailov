package com.izmaylov.hw11.util;

import com.izmaylov.hw11.model.Contact;

public class DynamicArray {

    public static Contact[] makeArrayBigger(Contact[] contacts) {
        Contact[] temp = new Contact[contacts.length * 2];
        for (int i = 0; i < contacts.length; i++) {
            temp[i] = contacts[i];
        }
        return temp;
    }

}
