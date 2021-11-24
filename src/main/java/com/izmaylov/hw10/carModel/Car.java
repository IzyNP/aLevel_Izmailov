package com.izmaylov.hw10.carModel;

import com.izmaylov.hw10.carService.Recovery;

public abstract class Car implements Recovery {

    private  int fuelMaxValue;
    private final int series;
    private final int year;
    private final String color;
    private int fuel;
    private final int consumption = 10;


    public Car(int series, int year, String color, int fuel) {
        this.series = series;
        this.year = year;
        this.color = color;
        this.fuel = fuel;
        setFuelMaxValue();
    }

    public void setFuelMaxValue() {
        if(fuel == 0){
            this.fuelMaxValue = 100;
        }else {
            this.fuelMaxValue = fuel;
        }
    }

    public int getFuelMaxValue() {
        return fuelMaxValue;
    }

    public int getSeries() {
        return series;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getConsumption() {
        return consumption;
    }

    public void startToMove(){
        if(fuel!=0){
            System.out.println("Машина едет");
            fuel -= consumption;
        }else {
            System.out.println("Недостаточно бензина");
        }
    }

    public abstract void info();
}
