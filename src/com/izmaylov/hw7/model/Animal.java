package com.izmaylov.hw7.model;

public class Animal {
    private final String name;
    private final AnimalType type;
    private int age;
    private int money;
    private double happy;
    private double purity;
    private double satiety;
    private int chanceToGetSick;
    private boolean isIll;
    private Present[] presents = new Present[0];

    public Animal(AnimalType type, String name) {
        this.name = name;
        this.isIll = false;
        this.type = type;
        this.age = 1;
        this.satiety = 100;
        this.purity = 100;
        this.happy = 50;
        this.chanceToGetSick = 10;
    }

    public String getName() {
        return name;
    }

    public int getChanceToGetSick() {
        return chanceToGetSick;
    }

    public boolean isIll() {
        return isIll;
    }

    public int getAge() {
        return age;
    }

    public double getPurity() {
        return purity;
    }

    public double getSatiety() {
        return satiety;
    }

    public int getMoney() {
        return money;
    }

    public double getHappy() {
        return happy;
    }

    public Present[] getPresents() {
        return presents;
    }

    public void setPresents(Present[] presents) {
        this.presents = presents;
    }

    public void setIll(boolean ill) {
        isIll = ill;
    }

    public void setHappy(int happy) {
        this.happy = happy;
    }

    public void setSatiety(int satiety) {
        this.satiety = satiety;
    }

    public void setPurity(int purity) {
        this.purity = purity;
    }

    public void addAge(int age) {
        this.age += age;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public void addHappy(int happy) {
        if(happy < 0 && this.happy < 10 && this.satiety < 50 && isIll){
            this.happy -= happy * 4.7;
        }else if(happy < 0 && this.happy < 10){
            this.happy -= happy * 1.2;
        }else if(happy < 0 && this.satiety < 50){
            this.happy -= happy * 1.5;
        }else if(happy < 0 && isIll){
            this.happy -= happy * 2;
        }else {
            this.happy -= happy;
        }
    }

    public void addPurity(int purity) {
        if(purity < 0 && this.happy < 10 && this.satiety < 50 && isIll){
            this.purity -= purity * 4.7;
        }else if(purity < 0 && this.happy < 10){
            this.purity -= purity * 1.2;
        }else if(purity < 0 & this.satiety < 50){
            this.purity -= purity * 1.5;
        }else if(purity < 0 && isIll){
            this.purity -= purity * 2;
        }else {
            this.purity -= purity;
        }
        if(this.purity < 50){
            chanceToGetSick *= 3;
        }
    }

    public void addSatiety(int satiety) {
        if(satiety < 0 && this.happy < 10 && this.satiety < 50 && isIll){
            this.purity -= satiety * 4.7;
        }else if(satiety < 0 && this.happy < 10){
            this.purity -= satiety * 1.2;
        }else if(satiety < 0 & this.satiety < 50){
            this.purity -= satiety * 1.5;
        }else if(satiety < 0 && isIll){
            this.purity -= satiety * 2;
        }else {
            this.purity -= satiety;
        }
    }

    public void showPresents(){
        if(this.presents.length > 0){
            System.out.println("Подарки Вашего питомца: ");
            for (int i = 0; i < presents.length; i++) {
                System.out.println(i+1 + ")" + presents[i] + ";");

            }

        }else{
            System.out.println("У питомца ещё нет подарков");
        }
    }

    @Override
    public String toString() {
        return "Ваш тамагочи: " +"\n" +
                "имя: " + name + ";\n" +
                "тип: " + type + ";\n" +
                "возраст: " + age + ";\n" +
                "деньги: " + money + ";\n" +
                "счастье: " + happy + ";\n" +
                "чистота: " + purity + ";\n" +
                "сытость: " + satiety + ".\n ";
    }
}
