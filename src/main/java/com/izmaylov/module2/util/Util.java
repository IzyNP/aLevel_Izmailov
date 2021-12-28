package com.izmaylov.module2.util;

import com.izmaylov.module2.model.Customer;
import com.izmaylov.module2.model.Product;

import java.util.*;
import java.util.stream.Collectors;

public class Util {
    public static int createLimit() {
        return (int) (Math.random() * 6000) + 1000;
    }

    public static void dayTotalInfo(Map<Customer, ArrayList<Product>> ledger) {
        System.out.println("Кол-во проданных телефонов: " + countTelephone(ledger));
        System.out.println("Кол-во проданных телевизоров: " + countTelevision(ledger));
        System.out.println("Минимальный заказ: " + minBill(ledger));
        System.out.println("Общая сумма заказов: " + totalOrder(ledger));
        System.out.println("Кол-во розничных заказов: " + numberOfRetailOrders(ledger));
        System.out.println("Первые 3 чека за день: " + firstThreeBills(ledger));
        System.out.println(customersUnderEighteen(ledger));
        System.out.println(sortAllOrders(ledger));

    }

    public static int randomNumber(int max, int min) {
        return (int) (Math.random() * max) + min;
    }

    private static int countTelevision(Map<Customer, ArrayList<Product>> ledger) {
        ArrayList<Product> products = new ArrayList<>();
        for (Map.Entry<Customer, ArrayList<Product>> mapValue : ledger.entrySet()) {
            products.addAll(mapValue.getValue());
        }
        List<Product> television = products.stream()
                .filter(x -> x.getType().equals("Television"))
                .collect(Collectors.toList());
        return television.size();
    }

    private static int countTelephone(Map<Customer, ArrayList<Product>> ledger) {
        ArrayList<Product> products = new ArrayList<>();
        for (Map.Entry<Customer, ArrayList<Product>> mapValue : ledger.entrySet()) {
            products.addAll(mapValue.getValue());
        }
        List<Product> telephone = products.stream()
                .filter(x -> x.getType().equals("Telephone"))
                .collect(Collectors.toList());
        return telephone.size();
    }

    private static String minBill(Map<Customer, ArrayList<Product>> ledger) {
        ArrayList<Customer> customers = new ArrayList<>(ledger.keySet());

        List<Customer> collect = customers.stream()
                .sorted(Customer::compareTo)
                .limit(1)
                .collect(Collectors.toList());

        return ledger.get(collect.get(0)) + " " + collect.get(0);
    }

    private static String totalOrder(Map<Customer, ArrayList<Product>> ledger) {
        ArrayList<Customer> customers = new ArrayList<>(ledger.keySet());
        final int[] totalOrder = {0};

        customers
                .forEach(x -> totalOrder[0] += x.getTotalOrderSum());

        return Arrays.toString(totalOrder);
    }

    private static int numberOfRetailOrders(Map<Customer, ArrayList<Product>> ledger){
        ArrayList<Customer> customers = new ArrayList<>(ledger.keySet());
        return (int) customers.stream()
                .filter(x -> x.getOrderType().equals("retail")).count();
    }

    private static LinkedHashMap<Object, Object> firstThreeBills(Map<Customer, ArrayList<Product>> ledger) {

        return ledger.entrySet()
                .stream()
                .limit(3)
                .collect(LinkedHashMap::new, (k, v) -> k.put(v.getKey(), v.getValue()), Map::putAll);
    }

    private static String customersUnderEighteen(Map<Customer, ArrayList<Product>> ledger){
        ArrayList<Customer> customers = new ArrayList<>(ledger.keySet());

        return customers.stream()
                .filter(x -> x.getAge() < 18)
                .peek(x -> x.setOrderType("low_age"))
                .collect(Collectors.toList()).toString();
    }

    private static List<Customer> sortAllOrders(Map<Customer, ArrayList<Product>> ledger){
        ArrayList<Customer> customers = new ArrayList<>(ledger.keySet());

        return customers.stream()
                .sorted(Comparator.comparing(Customer::getAge)
                        .thenComparing(Customer::getTotalOrderSize)
                        .thenComparing(Customer::getTotalOrderSum))
                .collect(Collectors.toList());
    }
}
