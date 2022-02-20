package com.izmaylov.module3.services;

import java.util.Scanner;

public class ConsoleService {
    private final AdminService adminService = new AdminService();
    private final Scanner scanner = new Scanner(System.in);
    private final String menu = "Menu:\n"
            + "1.Find subscriber with most send messages;\n"
            + "2.Find subscriber who made the most calls;\n"
            + "3.Find subscriber who most frequently surf internet;\n"
            + "4.Find top five subscribers by activity;\n"
            + "5.Find message by concrete word;\n"
            + "6.Find most popular device;\n"
            + "7.Find most popular service;\n";

    public void doSomething() {
        boolean isShouldContinue = true;
        System.out.println("Enter number to chose operation. Input 0 to exit.");
        while (isShouldContinue){
            System.out.println(menu);
            switch (scanner.next()){
                case "1":
                    System.out.println(adminService.getSubscriberWithMostSentMessages());
                    break;
                case "2":
                    System.out.println(adminService.getSubscriberWhoDidMostCalls());
                    break;
                case "3":
                    System.out.println(adminService.getSubscriberWhoMostFrequentlySurfInternet());
                    break;
                case "4":
                    System.out.println(adminService.getTopFiveSubscribersByActivity());
                    break;
                case "5":
                    System.out.println("Enter word to find message:");
                    scanner.nextLine();
                    String temp = scanner.nextLine();
                    System.out.println(adminService.getMessageByConcreteWord(temp));
                    break;
                case "6":
                    System.out.println(adminService.whichDeviceIsMostPopular());
                    break;
                case "7":
                    adminService.whichServiceMostPopular();
                    break;
                case "0":
                    isShouldContinue = false;
                    break;
            }
        }while (isShouldContinue);
    }

    private String getString(){
        if(scanner.hasNext()){
            scanner.reset();
        }
        return scanner.nextLine();
    }
}
