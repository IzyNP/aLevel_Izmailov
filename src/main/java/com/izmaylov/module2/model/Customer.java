package com.izmaylov.module2.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Customer implements Comparable<Customer>{
    private int id;
    private String email;
    private int age;
    private int totalOrderSum;
    private String orderType;
    private int totalOrderSize;

    @Override
    public int compareTo(Customer o) {
        return Integer.compare(totalOrderSum, o.totalOrderSum);
    }
}
