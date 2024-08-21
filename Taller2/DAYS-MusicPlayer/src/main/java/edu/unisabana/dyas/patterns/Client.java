package main.java.edu.unisabana.dyas.patterns;

import main.java.edu.unisabana.dyas.patterns.utils.AdvancedAudioPlayer;

// Cliente que utiliza directamente AdvancedAudioPlayer sin conocer la interfaz AudioPlayer
public class Client {
    public static void main(String[] args) {
        AdvancedAudioPlayer advancedPlayer = new AdvancedAudioPlayer();
        advancedPlayer.playMp4("video.mp4");
        advancedPlayer.stop();
    }
}