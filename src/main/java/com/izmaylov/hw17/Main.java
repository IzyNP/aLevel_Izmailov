package com.izmaylov.hw17;

import com.izmaylov.hw17.model.Box;
import com.izmaylov.hw17.util.Values;
import com.izmaylov.hw17.util.Util;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Работа с числами
        Values values = new Values();
        Util.summaryStatistic(values.integerList);
        Util.findMin(values.integerList);

        //Работа со строками
        Util.sort(values.strings);
        System.out.println();
        Util.checkDate(values.stringList);


        //Работа с Box\
        List<Box> boxes = Util.fillWithBoxes();
    }
}
