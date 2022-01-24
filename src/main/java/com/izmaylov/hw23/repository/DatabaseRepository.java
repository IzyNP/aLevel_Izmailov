package com.izmaylov.hw23.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Random;

public class DatabaseRepository extends AbstractRepository{
    private Connection connection = createConnection();

    public DatabaseRepository() throws SQLException {
    }

    public void createTableFactory(){
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE factory (Id SERIAL PRIMARY KEY, Name VARCHAR(10), Country VARCHAR(15))";
            statement.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createTableDevice(){
        try(Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE device (ID SERIAL PRIMARY KEY, Type VARCHAR(10), Model VARCHAR(10), Price INTEGER, Date_of_creation DATE, Description TEXT, Available BOOLEAN, FactoryId BIGINT REFERENCES public.factory (id))";
            statement.execute(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createFactory(){
        String[] country = {"USA","Japan","China","Ukraine"};
        String[] name = {"Apple","Samsung","Huawei", "Elecom"};
        FactoryRepository factoryRepository = new FactoryRepository();
        for (int i = 0; i < 4; i++) {
            factoryRepository.createFactory(name[i], country[i]);
        }
    }

    public void createDevice(){
        String[] devices = {"Telephone" , "Television"};
        String[] models = {"X", "Note 8", "P10", "M6", "3310", "XT15R7", "TR2654", "JJ77GY8", "QWERTY", "1567239"};
        Random random = new Random(1);
        DeviceRepository deviceRepository = new DeviceRepository();
        for (int i = 0; i < 10; i++) {
            if(i % 2 == 0){
                deviceRepository.createDevice(devices[0], models[i], 1500, Date.valueOf(LocalDate.now()), "description", true, random.nextInt() > 0 ? 1 : 2);
            }else{
                deviceRepository.createDevice(devices[1], models[i], 1500, Date.valueOf(LocalDate.now()), "description", true, random.nextInt() > 0 ? 3 : 4);
            }
        }
    }
}
