package com.dailylogger;

import java.util.Scanner;

public class logger {
    public static void sayHello() {
        System.out.println("How many minutes do you want to work? ");
        Scanner scr = new Scanner(System.in);
        String workDuration = scr.nextLine();
        System.out.println("How many minutes should your break be? ");
        String breakDuration = scr.nextLine();
        System.out.println("Okay, let's do it! We will work for " + workDuration + " minutes and then get a " + breakDuration + " minutes break.");
    }
}
