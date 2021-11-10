package com.izmaylov.hw6;

public class Garage {
    private static boolean status = true;

    public static void checkCar(Car car){
        if(!car.getEngine().getEngineType().equals(EngineType.ELECTICAL)){
            if(car.getPetrol() == 0){
                System.out.println("Проверка бензина непройдена по причине недостаточного количества");
                status = false;
            }
        }else{
            if(car.getBattery() == 0){
                System.out.println("Проверка батареи непройдена по причине низикого заряда батареи");
                status = false;
            }
        }

        if(car.getEngine().getPower() < 200){
            System.out.println("Проверка непройдена по причине низкого уровня мощности");
            status = false;
        }

        if(status){
            System.out.println("Машина готова к выезду.");
        }
    }
}
