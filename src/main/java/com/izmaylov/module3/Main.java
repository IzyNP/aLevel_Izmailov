package com.izmaylov.module3;

import com.izmaylov.module3.services.ConsoleService;
import org.flywaydb.core.Flyway;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "root";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Flyway flyway = Flyway.configure().dataSource(url, username, password).load();

        flyway.clean();
        flyway.migrate();


        ConsoleService consoleService = new ConsoleService();
        consoleService.doSomething();


    }
}
