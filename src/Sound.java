import java.net.URL;
import javax.sound.sampled.*;
public class Sound {
    Clip clip;
    URL[] soundURL = new URL[30]; // array of sounds, change as needed
    public Sound(){
        soundURL[0] = getClass().getResource("/resources/sounds/pokePH_title.wav");
        soundURL[1] = getClass().getResource("/resources/sounds/battleMusic.wav");
        soundURL[2] = getClass().getResource("/resources/sounds/select.wav");
        soundURL[3] = getClass().getResource("/resources/sounds/win.wav");
    }
    public void setFile(int i){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception ignored) {
        }
    }
    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
}
