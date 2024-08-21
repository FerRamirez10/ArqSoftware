package main.java.edu.unisabana.dyas.patterns;

import main.java.edu.unisabana.dyas.patterns.utils.*;

// Cliente que utiliza la interfaz AudioPlayer con el adaptador
public class Client {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AdvancedAudioPlayerAdapter(new AdvancedAudioPlayer());
        audioPlayer.play("mp4", "video.mp4");
        audioPlayer.play("vlc", "movie.vlc");
        audioPlayer.stop();
    }
}
