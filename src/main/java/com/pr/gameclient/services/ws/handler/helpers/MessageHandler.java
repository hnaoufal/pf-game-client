package com.pr.gameclient.services.ws.handler.helpers;

import com.google.gson.Gson;
import jakarta.websocket.Session;

public abstract class MessageHandler<T> {
    private Gson gson = new Gson();

    public final void run(Session session, String message) {
        final T object = gson.fromJson(message, getMessageClass());
        handle(session, object);
    }

    public abstract Class<T> getMessageClass();
    protected abstract void handle(Session session, T object);
}
