package com.pr.gameclient.services.ws.client.msginteraction.handler;

import com.pr.gameclient.services.ws.common.msginteraction.generic.MessageHandler;
import com.pr.gameclient.services.ws.common.msginteraction.message.StartGame;
import com.pr.gameclient.services.ws.mvp.ClientPresenter;
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
