package com.izmaylov.hw23.repository;

import com.izmaylov.hw23.entity.Factory;

import java.sql.*;
import java.util.Arrays;

public class FactoryRepository extends AbstractRepository {

    public void createFactory(String name, String country) {
        String sql = "INSERT INTO public.factory(name, country) Values (?, ?)";
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, country);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Factory getById(long id) {
        String sql = "SELECT * FROM device WHERE id = ?";
        try (Connection connection = createConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Factory factory = new Factory();
                    factory.setId(resultSet.getLong(1));
                    factory.setName(resultSet.getString(2));
                    factory.setCountry(resultSet.getString(3));
                    return factory;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public String getAllDevicesAndSumForFactory() {
        String sqlCount = "SELECT factory.id, COUNT(device.id) FROM factory JOIN device ON device.factoryId = factory.id GROUP BY factory.id";
        String sqlSum = "SELECT factory.id, SUM(device.price) FROM factory JOIN device ON device.factoryId = factory.id GROUP BY factory.id";
        String[] result = new String[4];
        int iter = 0;
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlCount);
            while (resultSet.next()) {
                result[iter++] = ("Factory " + resultSet.getLong(1) +" made " + resultSet.getInt(2) +" devices");

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        iter = 0;
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlSum);
            while (resultSet.next()) {
                result[iter++] += (" in the amount of " + resultSet.getInt(2));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Arrays.toString(result);
    }
}
