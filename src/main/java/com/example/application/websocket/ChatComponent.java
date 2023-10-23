package com.example.application.websocket;

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.shared.Registration;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import javax.management.Notification;
import java.util.ArrayList;
import java.util.List;

@SpringComponent
@UIScope
public class ChatComponent extends VerticalLayout {
    private final SimpMessagingTemplate messagingTemplate;
    private final TextField messageField;

    public ChatComponent(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
        this.messageField = new TextField("Message");
        Button sendButton = new Button("Send", event -> sendMessage());
        add(messageField, sendButton);
    }
    public void sendMessage() {
        String message = messageField.getValue();
        if(!message.isEmpty()) {
            ChatMessage chatMessage = new ChatMessage();
            chatMessage.setContent(message);
            chatMessage.setSender("User");

            messagingTemplate.convertAndSend("/topic/messages", chatMessage);
            messageField.clear();
        }else {
            System.out.println("Please enter a message");
        }
    }
    private List<ComponentEventListener<MessageSentEvent>> sentMessageListeners = new ArrayList<>();
    public Registration addMessageSentListener(ComponentEventListener<MessageSentEvent> listener) {
        return addListener(MessageSentEvent.class, listener);
    }

    public Registration addMessageReceivedListener(ComponentEventListener<MessageReceivedEvent> listener) {
        return addListener(MessageReceivedEvent.class, listener);
    }

    private void sendMessage(ChatMessage message) {
        // ... (existing code for sending messages)
        fireEvent(new MessageSentEvent(this, false, message));
        MessageSentEvent event = new MessageSentEvent(this, false, message);
        sentMessageListeners.forEach(listener -> listener.onComponentEvent(event));
    }

    private void processReceivedMessage(ChatMessage message) {
        // ... (existing code for processing received messages)
        fireEvent(new MessageReceivedEvent(this, false, message));
    }

}
