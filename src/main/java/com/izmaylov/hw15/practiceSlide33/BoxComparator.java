package com.izmaylov.hw15.practiceSlide33;

import java.util.Comparator;

public class BoxComparator implements Comparator<Box> {
    @Override
    public int compare(Box o1, Box o2) {
        if(o1.getVolume() > o2.getVolume() || o1.getVolume() == 0 || o2.getVolume() == 0){
            return -1;
        }else if(o1.getVolume() < o2.getVolume()){
            return 1;
        }else {
            return 0;
        }
    }
}
