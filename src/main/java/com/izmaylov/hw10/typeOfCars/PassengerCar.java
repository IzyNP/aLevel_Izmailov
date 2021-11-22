package com.izmaylov.hw10.typeOfCars;

import com.izmaylov.hw10.carModel.Car;
import com.izmaylov.hw10.carService.Recovery;

public class PassengerCar extends Car implements Recovery {
    private int passengers;

    public PassengerCar(int series, int year, String color, int fuel, int passengers) {
        super(series, year, color, fuel);
        this.passengers = passengers;
    }

    public void addPassengers() {
        if(passengers == 3){
            System.out.println("Невозможно посадить ещё одного, достигнуто максимальное кол-во пассажиров\n");
        }else{
            passengers++;
        }
    }

    @Override
    public void info() {
        System.out.println("Информация про автомобиль:\n" +
                "cерия: " + getSeries() + ";\n" +
                "год выпуска: " + getYear() + ";\n" +
                "цвет: " + getColor()  + ";\n" +
                "кол-во горючего: " + getFuel() + ";\n" +
                "расход горючего: " + getConsumption() + ";\n" +
                "максимальное кол-во горючего: " + getFuelMaxValue()  + ";\n" +
                "кол-во пассажиров: " + passengers);
    }

    @Override
    public void refuel() {
        setFuel(getFuelMaxValue());
        System.out.println("Автомобиль заправлен.");
    }
}
