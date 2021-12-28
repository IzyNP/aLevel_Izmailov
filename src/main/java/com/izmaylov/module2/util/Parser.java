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
    private static boolean done;

    private static BufferedReader createReader(String string) throws IOException {
        return new BufferedReader(new InputStreamReader(Objects.requireNonNull(classLoader.getResourceAsStream(string))));
    }

    private static void fillMap(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            values.put(strings[i], i);
        }
        done = true;
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
                    if (split[values.get("type")].equals("Telephone")) {
                        Telephone telephone = new Telephone();
                        telephone.setType(split[values.get("type")]);
                        telephone.setCountry(split[values.get("country")]);
                        telephone.setDiagonal(split[values.get("diagonal")]);
                        telephone.setModel(split[values.get("model")]);
                        telephone.setPrice(split[values.get("price")]);
                        telephone.setSeries(split[values.get("series")]);
                        telephone.setScreenType(split[values.get("screen type")]);
                        productList.add(telephone);
                    } else {
                        Television television = new Television();
                        television.setType(split[values.get("type")]);
                        television.setCountry(split[values.get("country")]);
                        television.setDiagonal(split[values.get("diagonal")]);
                        television.setModel(split[values.get("model")]);
                        television.setPrice(split[values.get("price")]);
                        television.setSeries(split[values.get("series")]);
                        television.setScreenType(split[values.get("screen type")]);
                        productList.add(television);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
