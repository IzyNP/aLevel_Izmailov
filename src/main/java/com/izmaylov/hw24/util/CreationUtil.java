package com.izmaylov.hw24.util;

import com.izmaylov.hw24.entity.Device;
import com.izmaylov.hw24.entity.Factory;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreationUtil {
    public static List<Factory> createFactory(){
        List<Factory> factoryList = new ArrayList<>();
        String[] country = {"USA","Japan","China","Ukraine"};
        String[] name = {"Apple","Samsung","Huawei", "Elecom"};
        for (int i = 0; i < 4; i++) {
            factoryList.add(new Factory(name[i], country[i]));
        }
        return factoryList;
    }

    public static List<Device> createDevice(List<Factory> factories){
        List<Device> deviceList = new ArrayList<>();
        String[] devices = {"Telephone" , "Television"};
        String[] models = {"X", "Note 8", "P10", "M6", "3310", "XT15R7", "TR2654", "JJ77GY8", "QWERTY", "1567239"};
        Random random = new Random(1);
        for (int i = 0; i < 10; i++) {
            if(i % 2 == 0){
                deviceList.add(new Device(devices[0], models[i], 1500, Date.valueOf(LocalDate.now()), "description", true, random.nextInt() > 0 ? factories.get(0) : factories.get(1)));
            }else{
                deviceList.add(new Device(devices[1], models[i], 1500, Date.valueOf(LocalDate.now()), "description", true, random.nextInt() > 0 ? factories.get(2) : factories.get(3)));
            }
        }
        return deviceList;
    }
}
