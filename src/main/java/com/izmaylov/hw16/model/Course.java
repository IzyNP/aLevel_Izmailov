package com.izmaylov.hw16.model;

import lombok.Getter;

@Getter
public enum Course {
    FIST_COURSE(1), SECOND_COURSE(2),THIRD_COURSE(3),FOURTH_COURSE(4),
    FIFTH_COURSE(5), SIXTH_COURSE(6);

    private int course;

    Course(int course){
        this.course = course;
    }


    @Override
    public String toString() {
        return "" + course;
    }
}
