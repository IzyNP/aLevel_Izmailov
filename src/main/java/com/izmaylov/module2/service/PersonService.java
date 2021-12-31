package com.izmaylov.module2.service;

import com.izmaylov.module2.model.Customer;
import com.izmaylov.module2.util.Util;

import java.util.Random;

public class PersonService {
    private static int id = 1;

    private String randomString() {
        Random random = new Random();
        String srt = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            int number = random.nextInt(52);
            stringBuilder.append(srt.charAt(number));
        }

        return stringBuilder.toString();
    }

    public Customer randomCustomer() {
        Customer customer = new Customer();

        customer.setId(id);
        customer.setAge(Util.randomNumber(80,11));
        customer.setEmail(randomString() + "@gmail.com");
        id++;

        return customer;
    }
}
