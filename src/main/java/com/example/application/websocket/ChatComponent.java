package com.example.application.websocket;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import javax.management.Notification;

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

}
