package com.izmaylov.module2.model;

import com.izmaylov.module2.util.Parser;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@ToString
public class Invoice {
    private final ArrayList<Product> products = Parser.csv("ProductList.csv");
    private String type;

    public void setType(String type) {
        this.type = type;
    }


}
