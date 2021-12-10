package com.izmaylov.hw15.practiceSlide33;

import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Box box1 = new Box(5);
        Box box2 = new Box(7);
        Box box3 = new Box(53);
        Box box4 = new Box(1);
        Box box5 = new Box(0);
        Box box6 = new Box(-1);
        BoxComparator boxComparator = new BoxComparator();

        Set<Box> set = new TreeSet<>(boxComparator);
        set.add(box1);
        set.add(box2);
        set.add(box3);
        set.add(box4);
        set.add(box5);
        set.add(box6);

        for (Box box : set) {
            System.out.println(box);
        }

    }
}
