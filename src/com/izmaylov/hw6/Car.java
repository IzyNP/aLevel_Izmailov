package com.izmaylov.hw6;

public class Car {
    private Manufacturer manufacturer;
    private Engine engine;
    private String colour;
    private int petrol;
    private int battery;



    public Car(Manufacturer manufacturer, Engine engine, String colour) {
        this.manufacturer = manufacturer;
        this.engine = engine;
        this.colour = colour;
        if(!engine.getEngineType().equals(EngineType.ELECTICAL)) {
            this.petrol = 100;
        }else{
            this.battery = 100;
        }
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public Engine getEngine() {
        return engine;
    }

    public String getColour() {
        return colour;
    }

    public int getPetrol() {
        return petrol;
    }

    public int getBattery() {
        return battery;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setBattery(int battery) {
        if(engine.getEngineType().equals(EngineType.ELECTICAL)){
            this.battery = battery;
        }else{
            System.out.println("Неподходящий тип двигателя");
        }
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }


    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setPetrol(int petrol) {
        if(!engine.getEngineType().equals(EngineType.ELECTICAL)) {
            this.petrol = petrol;
        }else{
            System.out.println("Неподходящий тип двигателя");
        }
    }

    private  void startEngine(String name) {
        System.out.println(name + " запустил двигатель.");
    }

    private boolean isEnoughPetrolLevel() {
        return petrol >= 50;
    }

    @Override
    public String toString() {
        return "Марка автомобиля: " + manufacturer.getRussianName() + "\n" +
                "цвет: " + colour + "\n" +
                "тип двигателя: " + engine.getEngineType() + "\n" +
                "мощность: " + engine.getPower();
    }
}
