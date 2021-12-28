package com.izmaylov.module2.service;

import com.izmaylov.module2.exception.InvalidString;
import com.izmaylov.module2.model.Customer;
import com.izmaylov.module2.model.Invoice;
import com.izmaylov.module2.model.Product;
import com.izmaylov.module2.util.Util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ShopService {
    private static final int limit = Util.createLimit();
    private final Invoice invoice = new Invoice();
    private final ArrayList<Product> products = invoice.getProducts();
    private final Map<Customer, ArrayList<Product>> ledger = new LinkedHashMap<>();
    private int orderCount = 0;


    public Map<Customer, ArrayList<Product>> getLedger() {
        return ledger;
    }



    public void createOrder(Customer customer) {
        ArrayList<Product> order = new ArrayList<>();
        int productsQuantity = Util.randomNumber(5,1);
        for (int i = 0; i < productsQuantity; i++) {
            if (products.get(i).isEmptyValue()) {
                try {
                    throw new InvalidString();
                } catch (InvalidString e) {
                    e.getMessage();
                }
            } else {
                order.add(products.get(i));
            }
        }
        customer.setTotalOrderSum(checkOrderCost(order));
        customer.setTotalOrderSize(order.size());
        logger(customer);
        ledger.put(customer, order);
        customer.setOrderType(invoice.getType());
        orderCount++;
    }

    private void logger(Customer customer) {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("E dd.MM.yyyy 'в' hh:mm:ss");
        File log = new File("Logs.txt");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(log, true))) {
            bufferedWriter.write(format.format(date) + ", " + customer.getEmail() + ", " + invoice.getType() + ";\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private int checkOrderCost(ArrayList<Product> products) {
        int cost = 0;
        for (Product product : products) {
            cost += product.getPrice();
        }
        if (cost > limit) {
            invoice.setType("wholesale");
        } else {
            invoice.setType("retail");
        }
        return cost;
    }

    public void smt() {
        Util.dayTotalInfo(ledger);
    }
}
