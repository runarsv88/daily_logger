package com.dailylogger;

import java.util.Scanner;
import java.nio.file.*;
import java.io.IOException;

import com.dailylogger.utils.Utils;
import com.dailylogger.utils.MP3player;

public class Logger {

    private Scanner scr = new Scanner(System.in);
    private String soundPath;
    private final Integer repetitions = 3;

    public Logger(String soundPath) {
        this.soundPath = soundPath;
    }

    public String askForInput() {
        System.out.println("How many minutes do you want to work? ");
        Integer workDuration = scr.nextInt();
        System.out.println("How many minutes should your break be? ");
        Integer breakDuration = scr.nextInt();
        scr.skip("((?<!\\R)\\s)*"); //Drop any leftover line break chars
        System.out.println("Okay, let's do it! We will work for " + workDuration
                + " minutes and then get a " + breakDuration + " minutes break.");
        return workDuration + ";" + breakDuration;
    }

    public void askForAndWriteLog() {
        String logfile = "logs/" + Utils.getDateTimestamp(Utils.TimestampFormat.DATE) + ".txt";
        System.out.println("Write a short log entry to sum up your work: ");
        String logEntry = scr.nextLine();
        logEntry = Utils.getDateTimestamp(Utils.TimestampFormat.TIME) + " - " + logEntry + "\n";
        try {
            System.out.println("Writing to log");
            Files.write(Paths.get(logfile), logEntry.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Something went wrong and the log entry could not be written to " + logfile);
        }
    }

    public void playSound() {
        MP3player player = new MP3player(soundPath);
        player.playSound(repetitions);
    }

}
