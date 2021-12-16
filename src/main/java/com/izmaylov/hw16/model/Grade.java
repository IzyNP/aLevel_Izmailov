package com.izmaylov.hw16.model;

import lombok.Getter;

@Getter
public enum Grade {
    A(5),B(4),C(3),D(2),E(1);

    private int gradeNumber;

    Grade(int gradeNumber){
        this.gradeNumber = gradeNumber;
    }


    @Override
    public String toString() {
        return "" + gradeNumber;
    }
}
