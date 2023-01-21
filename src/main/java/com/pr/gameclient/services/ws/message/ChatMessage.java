package com.pr.gameclient.services.ws.message;

public class ChatMessage {
    private String message;

    public ChatMessage(String login) {
        this.message = login;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String login) {
        this.message = login;
    }
}
