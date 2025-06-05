import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundPlayer {
    
    private static Clip clip;

    public static void playSound(String soundFilePath) {
        try {
            // Stop and close the previous clip if it's still playing
            if (clip != null && clip.isRunning()) {
                clip.stop();
                clip.close();
            }

            // Load the sound file
            File soundFile = new File(soundFilePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();  // Get the clip
            clip.open(audioStream);        

            // Play the sound
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
