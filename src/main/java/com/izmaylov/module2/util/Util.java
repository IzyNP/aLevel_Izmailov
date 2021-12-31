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
        System.out.println("Кол-во проданных телефонов: " + countProductByType(ledger,"Television"));
        System.out.println("Кол-во проданных телевизоров: " + countProductByType(ledger,"Telephone"));
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

    private static int countProductByType(Map<Customer, ArrayList<Product>> ledger, String type) {
        List<Product> television = ledger.values().stream()
                .flatMap(Collection::stream)
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
        return television.size();
    }


    private static String minBill(Map<Customer, ArrayList<Product>> ledger) {

        ArrayList<Customer> customers = new ArrayList<>(ledger.keySet());

        final Customer customer = customers.stream()
                .sorted(Customer::compareTo)
                .findFirst().orElseThrow(IllegalStateException::new);


        return customer.toString() + " " + ledger.get(customer);
    }

    private static int totalOrder(Map<Customer, ArrayList<Product>> ledger) {
        ArrayList<Customer> customers = new ArrayList<>(ledger.keySet());


        return customers.stream()
                .mapToInt(Customer::getTotalOrderSum)
                .sum();
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
                .map(Customer::toString)
                .collect(Collectors.joining("\n"));
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
