package com.izmaylov.hw10.typeOfCars;

import com.izmaylov.hw10.carModel.Car;
import com.izmaylov.hw10.carService.Recovery;

public class Truck extends Car implements Recovery {

    private int cargo;
    private final int consumption = super.getConsumption() * 2;
    private final int fuelMaxValue = super.getFuelMaxValue() * 3;

    public Truck(int series, int year, String color, int fuel, int cargo) {
        super(series, year, color, fuel);
        this.cargo = cargo;
    }

    public int getCargo() {
        return cargo;
    }

    public void loading(int cargo) {
        this.cargo +=cargo;
    }

    public void unloading(int cargo){
        this.cargo -=cargo;
    }

    @Override
    public void startToMove() {
        if(this.getFuel() != 0){
            System.out.println("Машина начала движение.");
            this.setFuel(this.getFuel() - consumption);
        }else{
            System.out.println("Недостаточно бензина");
        }
    }

    @Override
    public void info() {
        System.out.println("Информация про автомобиль:\n" +
                "cерия: " + this.getSeries() + ";\n" +
                "год выпуска: " + this.getYear() + ";\n" +
                "цвет: " + this.getColor()  + ";\n" +
                "кол-во горючего: " + this.getFuel() + ";\n" +
                "расход горючего: " + consumption + ";\n" +
                "максимальное кол-во горючего: " + fuelMaxValue  + ";\n" +
                "загруженность: " + this.cargo);
    }

    @Override
    public void refuel() {
        setFuel(this.fuelMaxValue);
        System.out.println("Автомобиль заправлен.");
    }
}
