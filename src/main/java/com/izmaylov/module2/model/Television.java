package com.izmaylov.module2.model;

public class Television extends Product{
    @Override
    public String toString() {

        return "Телевизор. " +
                " диагональ: " + getDiagonal() +
                " серия: " + getSeries() +
                " тип дисплея: " + getScreenType() +
                " страна производитель: " + getCountry() +
                " цена: " + getPrice() + ";";
    }
}
