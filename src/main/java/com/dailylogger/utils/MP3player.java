package com.dailylogger.utils;

import jaco.mp3.player.MP3Player;
import java.io.File;

public class MP3player {
    private String soundPath;

    public MP3player(String soundPath) {
        this.soundPath = soundPath;
    }

    public void playSound() {
        System.out.println("Let's play a sound!");
        PlayerThread playerThread = new PlayerThread();
        playerThread.start();
    }

    class PlayerThread extends Thread {
        public void run() {
            try {
                new MP3Player(new File(soundPath)).play();
            } catch (Exception e) {
                System.out.println(e);
                throw e;
            }
        }
    }
}
