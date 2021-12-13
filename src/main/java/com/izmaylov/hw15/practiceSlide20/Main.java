package com.izmaylov.hw15.practiceSlide20;

public class Main {
    public static void main(String[] args) {
        MyList<String> myList = new MyList<>();

        myList.add("123");
        myList.add("1234");
        myList.add("1235");
        myList.add("1236");
        myList.add("1237");
        myList.add("1238");
        System.out.println(myList.getFromLast("1234"));

    }
}
