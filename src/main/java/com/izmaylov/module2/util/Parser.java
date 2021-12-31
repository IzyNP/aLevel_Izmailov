package com.izmaylov.module2.util;

import com.izmaylov.module2.model.Product;
import com.izmaylov.module2.model.Telephone;
import com.izmaylov.module2.model.Television;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Parser {
    private static final ArrayList<Product> productList = new ArrayList<>();
    private static final ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    private static final Map<String, Integer> values = new LinkedHashMap<>();

    private static BufferedReader createReader(String string) throws IOException {
        return new BufferedReader(new InputStreamReader(Objects.requireNonNull(classLoader.getResourceAsStream(string))));
    }

    private static void fillMap(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            values.put(strings[i], i);
        }
    }


    public static ArrayList<Product> csv(String string) {
        String temp;
        int iter = 0;
        try {
            BufferedReader reader = createReader(string);
            while ((temp = reader.readLine()) != null) {
                String[] split = temp.split(",");
                if(iter == 0) {
                    fillMap(split);
                    iter++;
                }else {
                    Product product;
                    if (split[values.get("type")].equals("Telephone")) {
                        product = new Telephone();
                    } else {
                        product = new Television();
                    }
                    product.setType(split[values.get("type")]);
                    product.setCountry(split[values.get("country")]);
                    product.setDiagonal(split[values.get("diagonal")]);
                    product.setModel(split[values.get("model")]);
                    product.setPrice(split[values.get("price")]);
                    product.setSeries(split[values.get("series")]);
                    product.setScreenType(split[values.get("screen type")]);
                    productList.add(product);
                    }
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
