package com.pr.gameclient.services.ws.handler;

import com.pr.gameclient.services.ws.handler.helpers.MessageHandler;
import com.pr.gameclient.services.ws.message.StartGame;
import com.pr.gameclient.controller.ClientPresenter;
import jakarta.websocket.Session;

public class StartGameHandler extends MessageHandler<StartGame> {
    @Override
    public Class<StartGame> getMessageClass() {
        return StartGame.class;
    }

    @Override
    protected void handle(Session session, StartGame object) {
        ClientPresenter.getInstance().startGame();
    }
}
