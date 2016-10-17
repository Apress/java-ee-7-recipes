/*
 * Recipe 17-1:  WebSocket Endpoint
 */
package org.javaeerecipes.chapter17;


import javax.websocket.OnMessage;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author Juneau
 */
@ServerEndpoint("/bookChatEndpoint")
public class BookChatEndpoint {
    @OnMessage
    public String messageReceiver(String message) {
        return "Message Received: " + message;
    }
}
