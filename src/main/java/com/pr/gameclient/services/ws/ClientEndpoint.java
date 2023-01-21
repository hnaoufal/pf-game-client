package com.pr.gameclient.services.ws;

import com.pr.gameclient.services.ws.handler.ClientMessageHandler;
import com.pr.gameclient.services.ws.handler.helpers.Message;
import com.pr.gameclient.services.ws.message.LoginMessage;
import com.pr.gameclient.controller.ClientPresenter;
import jakarta.websocket.*;

import java.io.IOException;

@jakarta.websocket.ClientEndpoint()
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

        System.out.println("Sending request: '" + login + "' with session " + session.getId());

        sendObject(new LoginMessage(login));
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        messageHandler.handle(session, message);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("Communication error, saying hello to '" + login + "' with session " + session.getId());
        System.out.println(throwable);

        this.session = null;
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("Closing connction" + session.getId());
        this.session = null;
    }

    public void sendObject(Object obj) {
        try {
            this.session.getBasicRemote().sendText(Message.toStringMessage(obj));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Message send" + Message.toStringMessage(obj));
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
