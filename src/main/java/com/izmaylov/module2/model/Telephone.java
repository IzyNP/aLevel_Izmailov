package com.izmaylov.module2.model;

public class Telephone extends Product{
    @Override
    public String toString() {
        return "Телефон. " + "модель: " + getModel() +  " серия: " + getSeries() +  " тип дисплея: " + getScreenType() +  " цена: " + getPrice() + ";";
    }
}
