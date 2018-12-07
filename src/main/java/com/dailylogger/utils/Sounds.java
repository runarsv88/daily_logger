package com.dailylogger.utils;

import java.io.*;
import javax.sound.sampled.*;

public class Sounds {
    private String soundPath;

    public Sounds(String soundPath) {
        this.soundPath = soundPath;
    }

    public void playSound(Integer numberOfTimes) {
        PlayerThread playerThread = new PlayerThread(numberOfTimes);
        playerThread.start();
    }

    class PlayerThread extends Thread {
        private Integer numberOfTimes;
        
        public PlayerThread(Integer numberOfTimes) {
            this.numberOfTimes = numberOfTimes;
        }

        public void run() {
            try{
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(soundPath));
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);
                clip.loop(numberOfTimes - 1);
            } catch (Exception e) {
                System.out.println("Failure!!!! ABORT");
                e.printStackTrace();
            }
        }
    }
}
