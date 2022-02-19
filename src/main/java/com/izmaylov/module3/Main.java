package com.izmaylov.module3;

import com.izmaylov.module3.services.AdminService;
import org.flywaydb.core.Flyway;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "root";

        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Flyway flyway = Flyway.configure().dataSource(url,username,password).load();

        flyway.clean();
        flyway.migrate();



        AdminService adminService = new AdminService();
        System.out.println(adminService.getMessageByConcreteWord("Praesent"));
        System.out.println(adminService.getSubscriberWhoDidMostCalls());
        System.out.println(adminService.getSubscriberWithMostSentMessages());
        System.out.println(adminService.getSubscriberWhoMostFrequentlySurfInternet());
        System.out.println("Most popular device is " + adminService.whichDeviceIsMostPopular());
        System.out.println("Top 5 subscribers: " + adminService.getTopFiveSubscribersByActivity());
        adminService.whichServiceMostPopular();

    }
}
