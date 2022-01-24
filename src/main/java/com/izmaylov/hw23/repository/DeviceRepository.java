package com.izmaylov.hw23.repository;

import com.izmaylov.hw23.entity.Device;
import com.izmaylov.hw23.entity.FactoryDevice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeviceRepository extends AbstractRepository {

    public void createDevice(String type, String model, int price, Date date, String description, boolean available, long factoryId) {
        String sql = "INSERT INTO public.device(type, model, price, date_of_creation, description, available, factoryId) Values (?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, type);
            statement.setString(2, model);
            statement.setInt(3, price);
            statement.setDate(4, date);
            statement.setString(5, description);
            statement.setBoolean(6, available);
            statement.setLong(7, factoryId);
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public Device getById(long id) {
        String sql = "SELECT * FROM device WHERE id = ?";
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Device device = new Device();
                    device.setId(resultSet.getLong(1));
                    device.setType(resultSet.getString(2));
                    device.setModel(resultSet.getString(3));
                    device.setPrice(resultSet.getInt(4));
                    device.setDateOfCreation(resultSet.getDate(5));
                    device.setDescription(resultSet.getString(6));
                    device.setAvailable(resultSet.getBoolean(7));
                    device.setFactoryId(resultSet.getLong(8));
                    return device;
                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public void updateDevice(Device device) {
        String sql = "UPDATE device SET type = ?, model = ?, price = ?, date_of_creation = ?, description = ?, available = ? WHERE id = ?";
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(7, device.getId());
            statement.setString(1, device.getType());
            statement.setString(2, device.getModel());
            statement.setInt(3, device.getPrice());
            statement.setDate(4, device.getDateOfCreation());
            statement.setString(5, device.getDescription());
            statement.setBoolean(6, device.isAvailable());
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public void deleteDevice(long id) {
        String sql = "DELETE FROM device WHERE id = ?";
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }

    public List<FactoryDevice> getAllDevicesFromFactory(long id) {
        String sql = "SELECT * FROM device  INNER JOIN  factory ON device.factoryID = factory.id WHERE factoryID = ?";
        List<FactoryDevice> deviceList = new ArrayList<>();
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                FactoryDevice device = new FactoryDevice();
                device.setId(resultSet.getLong(1));
                device.setType(resultSet.getString(2));
                device.setModel(resultSet.getString(3));
                device.setPrice(resultSet.getInt(4));
                device.setDateOfCreation(resultSet.getDate(5));
                device.setDescription(resultSet.getString(6));
                device.setAvailable(resultSet.getBoolean(7));
                device.setFactoryId(resultSet.getLong(8));
                device.setName(resultSet.getString(10));
                device.setCountry(resultSet.getString(11));
                deviceList.add(device);
            }
            return deviceList;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

}
