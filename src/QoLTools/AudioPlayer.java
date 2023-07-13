package QoLTools;
import java.io.File;
import javax.sound.sampled.*;

public class AudioPlayer {
    private static Clip clip;
    public static void setAudio(File audioFile) {
        try{
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(audioFile));
        } catch(Exception e) {
            ExceptionHandler.handleException(e);
        }
    }
    public static void playAudio(boolean loop) {
        if (clip != null && !clip.isRunning()) {
            if (loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                clip.loop(0);
            }
            clip.start();
        }
    }
    public static void stopAudio() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
