package com.izmaylov.module2;

import com.izmaylov.module2.model.Customer;
import com.izmaylov.module2.service.PersonService;
import com.izmaylov.module2.service.ShopService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ShopService shopService = new ShopService();
        PersonService personService = new PersonService();
        Customer customer = personService.randomCustomer();
        Customer customer1 = personService.randomCustomer();
        Customer customer2 = personService.randomCustomer();
        Customer customer3 = personService.randomCustomer();
        Customer customer4 = personService.randomCustomer();
        Customer customer5 = personService.randomCustomer();
        Customer customer6 = personService.randomCustomer();
        Customer customer7 = personService.randomCustomer();
        Customer customer8 = personService.randomCustomer();
        Customer customer9 = personService.randomCustomer();
        shopService.createOrder(customer);
        shopService.createOrder(customer1);
        shopService.createOrder(customer2);
        shopService.createOrder(customer3);
        shopService.createOrder(customer4);
        shopService.createOrder(customer5);
        shopService.createOrder(customer6);
        shopService.createOrder(customer7);
        shopService.createOrder(customer9);
        shopService.createOrder(customer8);
        shopService.smt();

    }
}
