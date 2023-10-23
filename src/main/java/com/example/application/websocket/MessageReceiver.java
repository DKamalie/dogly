package com.example.application.websocket;

import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.stereotype.Component;
import java.lang.reflect.Type;
@Component
public class MessageReceiver {
    public StompFrameHandler stompFrameHandler(){
        return new StompFrameHandler() {
            @Override
            public Type getPayloadType(StompHeaders stompHeaders) {
                return byte[].class;
            }
            @Override
            public void handleFrame(StompHeaders stompHeaders, Object o) {
                byte[] payload = (byte[]) o;
                String message = new String(payload);
            }
        };
    }

}