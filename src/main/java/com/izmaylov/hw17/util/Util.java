package com.izmaylov.hw17.util;

import com.izmaylov.hw17.model.Box;
import com.izmaylov.hw17.model.Item;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Util {
    private static final Random random = new Random(Values.min);

    public static void sort(String[] strings) {
        Stream.of(strings)
                .sorted()
                .forEach(s -> System.out.print(s + " "));
    }

    public static void summaryStatistic(List<Integer> integerList) {
        IntSummaryStatistics summaryStatistics = integerList.stream()
                .mapToInt(x -> x)
                .filter(integer -> integer >= 0)
                .summaryStatistics();
        System.out.println(summaryStatistics);
    }

    public static void checkDate(List<String> stringList) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        boolean b = stringList.stream()
                .map(s -> LocalDate.parse(s, formatter))
                .anyMatch(localDate -> localDate.getYear() == 2021);
        System.out.println(b);
    }

    public static void findMin(List<Integer> integerList) {
        integerList.stream()
                .reduce(((integer, integer2) -> integer < integer2 ? integer : integer2))
                .ifPresent(System.out::println);
    }

    public static List<Box> fillWithBoxes() {
        List<Box> temp = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            temp.add(new Box());
        }
        return temp;
    }

    private static int limitForFilter(){
        return random.nextInt(Values.max);
    }

    public static void filterAndSortList(List<Box> list){
        List<Item> sortedItemList = list.stream()
                .filter(box -> box.getItems().size() <= limitForFilter())
                .flatMap(box -> box.getItems().stream())
                .sorted(Comparator.comparing(Item::getCost))
                .collect(Collectors.toList());
        System.out.println(sortedItemList);

    }

}
