package com.izmaylov.hw23;

import com.izmaylov.hw23.entity.Device;
import com.izmaylov.hw23.repository.DatabaseRepository;
import com.izmaylov.hw23.repository.DeviceRepository;
import com.izmaylov.hw23.repository.FactoryRepository;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        DatabaseRepository repository = new DatabaseRepository();
        DeviceRepository deviceRepository = new DeviceRepository();
        FactoryRepository factoryRepository = new FactoryRepository();
        repository.createTableFactory();
        repository.createTableDevice();
        repository.createFactory();
        repository.createDevice();

        Device device = deviceRepository.getById(4);
        deviceRepository.getAllDevicesFromFactory(3).forEach(System.out::println);
        device.setDescription("12312");
        device.setPrice(499);
        device.setAvailable(false);
        deviceRepository.updateDevice(device);
        deviceRepository.deleteDevice(5);

        System.out.println(factoryRepository.getAllDevicesAndSumForFactory());

    }
}
