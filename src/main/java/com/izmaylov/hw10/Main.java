package com.izmaylov.hw10;

import com.izmaylov.hw10.carService.Recovery;
import com.izmaylov.hw10.typeOfCars.Truck;

public class Main {

    public static void main(String[] args) {
        Recovery recovery = new Recovery() {
            @Override
            public void refuel() {
                System.out.println("Восстанавливает топливо машины до полного значения");
            }
        };
        recovery.refuel();
        Recovery recovery1 = new Truck(1234,2005,",WHITE",100, 500);
        recovery1.refuel();
    }
}
