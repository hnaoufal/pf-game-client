package com.pr.gameclient.services.ws.client;

import com.pr.gameclient.services.ws.client.msginteraction.ClientMessageHandler;
import com.pr.gameclient.services.ws.common.msginteraction.generic.Message;
import com.pr.gameclient.services.ws.common.msginteraction.message.LoginMessage;
import com.pr.gameclient.services.ws.mvp.ClientPresenter;
import jakarta.websocket.*;

import java.io.IOException;

public class ClientEndpoint {
    private final String login;

    ClientMessageHandler messageHandler = new ClientMessageHandler();

    Session session;
    public ClientEndpoint(String login) {
        this.login = login;
    }

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        ClientPresenter.getInstance().setClientEndpoint(this);

        System.out.println("huhuh");
        sendObject(new LoginMessage(login));
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        messageHandler.handle(session, message);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("Communication error, saying hello to '" + login + "' with session " + session.getId());

        this.session = null;
    }

    @OnClose
    public void onClose(Session session) {
            this.session = null;
    }

    public void sendObject(Object obj) {
        try {
            this.session.getBasicRemote().sendText(Message.toStringMessage(obj));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendText(String text) {
        try {
            this.session.getBasicRemote().sendText(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLogin() {
        return login;
    }
}
