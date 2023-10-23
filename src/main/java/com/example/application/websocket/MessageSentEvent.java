package com.example.application.websocket;

import com.vaadin.flow.component.ComponentEvent;

public class MessageSentEvent extends ComponentEvent<ChatComponent> {

    private final ChatMessage message;

    public MessageSentEvent(ChatComponent source, boolean fromClient, ChatMessage message) {
        super(source, fromClient);
        this.message = message;
    }

    public ChatMessage getMessage() {
        return message;
    }
}

