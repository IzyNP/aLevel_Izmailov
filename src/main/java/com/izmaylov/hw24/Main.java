package com.izmaylov.hw24;

import com.izmaylov.hw24.entity.Device;
import com.izmaylov.hw24.entity.Factory;
import com.izmaylov.hw24.repository.DatabaseRepository;
import com.izmaylov.hw24.util.CreationUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Factory> factories = CreationUtil.createFactory();
        List<Device> devices = CreationUtil.createDevice(factories);
        DatabaseRepository databaseRepository = new DatabaseRepository();


        factories.forEach(databaseRepository::addFactory);
        devices.forEach(databaseRepository::addDevice);


        Device updatedDevice = databaseRepository.getDeviceById(1);
        Device deletedDevice = databaseRepository.getDeviceById(3);
        Factory factory =  databaseRepository.getFactoryById(1);


        System.out.println(factory);
        updatedDevice.setAvailable(false);
        updatedDevice.setDescription("updated description");
        databaseRepository.updateDevice(updatedDevice);
        databaseRepository.deleteDevice(deletedDevice);
        System.out.println(databaseRepository.getAllDevicesFromFactory(3));
        databaseRepository.showAllDevicesAndSumForFactory(3);
    }
}
