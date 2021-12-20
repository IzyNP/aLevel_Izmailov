package com.izmaylov.hw17.util;

import com.izmaylov.hw17.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Values {
    public String[] strings ;
    public List<String> stringList = new ArrayList<>();
    public List<Integer> integerList = new ArrayList<>();
    private  static final Random random = new Random();
    public static int min = 100;
    public static int max = 0;


        public Values(){
            strings = new String[]{"one", "four", "five", "two", "three", "seven", "six", "eight", "nine"};

            stringList.add("1995/12/08");
            stringList.add("2000/12/08");
            stringList.add("2005/12/08");
            stringList.add("2010/12/08");
            stringList.add("2021/12/08");

            for (int i = 0; i < 5; i++) {
                integerList.add(random.nextInt(25));
            }
        }

        public static Item createItem(){
            String srt = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < srt.length(); i++) {
                int number = random.nextInt(52);
                stringBuilder.append(srt.charAt(number));
            }
            int cost = random.nextInt(100);
            if(cost < min){
                min = cost;
            }
            if(cost > max){
                cost = max;
            }

            return new Item(stringBuilder.toString(), cost);
        }
}
