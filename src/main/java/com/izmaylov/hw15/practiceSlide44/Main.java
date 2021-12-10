package com.izmaylov.hw15.practiceSlide44;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Nikita");
        strings.add("Izmailov");
        strings.add("Homework");
        System.out.println(Util.stringIntegerMap(strings));
    }
}
