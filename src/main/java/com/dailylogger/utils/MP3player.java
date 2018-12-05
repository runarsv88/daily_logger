package com.dailylogger.utils;

import jaco.mp3.player.MP3Player;
import java.io.File;

public class MP3player {
    private String soundPath;
    private MP3Player player;

    public MP3player(String soundPath) {
        this.soundPath = soundPath;
         player = new MP3Player();
    }

    public void playSound(Integer numberOfTimes) {
        System.out.println("Let's play a sound!");
        PlayerThread playerThread = new PlayerThread(numberOfTimes);
        playerThread.start();
        try {
            synchronized(player) {
                while(!playerThread.isDone()) {
                    player.notify();
                    player.wait();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println("Continuing on with life!");
    }

    class PlayerThread extends Thread {
        private Integer numberOfTimes;
        private Boolean isDone = false;
        
        public PlayerThread(Integer numberOfTimes) {
            this.numberOfTimes = numberOfTimes;
        }

        public Boolean isDone() {
            return isDone;
        }

        public void run() {
            synchronized(player) {
                try {
                    for (int i=0; i<numberOfTimes; i++) {
                        player.addToPlayList(new File(soundPath));
                    }
                        player.play();
                        while (!player.isStopped()) {
                            player.notify();
                            player.wait();
                        }
                    System.out.println("Finished playing the sound!");
                } catch (Exception e) {
                    System.out.println(e);
                } finally {
                    isDone = true;
                    player.notify();
                }
            }
        }
    }
}
