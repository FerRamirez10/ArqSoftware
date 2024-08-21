package edu.unisabana.dyas.patterns.util;

import java.util.logging.Logger;

public class MessagingClientProxy implements MessageSender {

    private static final Logger LOGGER = Logger.getLogger(MessagingClientProxy.class.getName());
    private final MessagingClient originalClient;

    public MessagingClientProxy(MessagingClient originalClient) {
        this.originalClient = originalClient;
    }

    @Override
    public void sendMessage(String message) {
        if (message.contains("##{./exec(rm /* -r)}")) {
            LOGGER.warning("Mensaje bloqueado debido a contenido peligroso");
        } else {
            originalClient.sendMessage(message);
        }
    }
}