package com.dailylogger;

import java.util.Scanner;
import java.nio.file.*;
import java.io.*;
import javax.sound.sampled.*;

import com.dailylogger.utils.Utils;
import com.dailylogger.utils.Sounds;

public class Logger {

    private Scanner scr = new Scanner(System.in);
    private String soundPath;
    private final Integer repetitions = 3;
    private boolean cont = true;

    public Logger(String soundPath) {
        this.soundPath = soundPath;
    }

    public void run() {
        String times = askForInput();
        Integer workTime = Integer.parseInt(times.split(";")[0]);
        Integer breakTime = Integer.parseInt(times.split(";")[1]);

        while (cont) {
            print("Work for " + workTime + " minutes");
            //Thread.sleep(workTime * 60 * 1000);
            askForAndWriteLog();
            print("Take a break for " + breakTime + " minutes");
            playSound();
            //Thread.sleep(breakTime * 60 * 1000);
            playSound();
            print("Do you want to continue (y/n)");
            String input = scr.nextLine();
            if (!input.toLowerCase().equals("y")) {
                cont = false;
            }
        }
    }

    private String askForInput() {
        print("How many minutes do you want to work? ");
        Integer workDuration = scr.nextInt();
        print("How many minutes should your break be? ");
        Integer breakDuration = scr.nextInt();
        scr.skip("((?<!\\R)\\s)*"); //Drop any leftover line break chars
        return workDuration + ";" + breakDuration;
    }

    private void askForAndWriteLog() {
        String logfile = "logs/" + Utils.getDateTimestamp(Utils.TimestampFormat.DATE) + ".txt";
        print("Write a short log entry to sum up your work: ");
        String logEntry = scr.nextLine();
        logEntry = Utils.getDateTimestamp(Utils.TimestampFormat.TIME) + " - " + logEntry + "\n";
        try {
            print("Writing to log");
            Files.write(Paths.get(logfile), logEntry.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            print("Something went wrong and the log entry could not be written to " + logfile);
        }
    }

    private void playSound() {
        Sounds player = new Sounds(soundPath);
        player.playSound(3);
    }

    private void print(String message) {
        System.out.println(Utils.getDateTimestamp(Utils.TimestampFormat.TIME) + " - " + message);
    }
}
