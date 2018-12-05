import com.dailylogger.Logger;

public class main {
    private static String soundPath = "src/main/resources/A-Tone.wav";

    public static void main(String[] args) {
        Logger logger = new Logger(soundPath);
        System.out.println("I just want to play this sound");
        logger.playSound();
        System.out.println("...and nothing more!!");
        logger.askForInput();
        logger.askForAndWriteLog();
    }
}
