package edu.unisabana.dyas.patterns.util;

// Clase original proporcionada por terceros
public class MessagingClient implements MessageSender {
    
    @Override
    public void sendMessage(String message) {
        System.out.println("Sending message: " + message);
    }
}
