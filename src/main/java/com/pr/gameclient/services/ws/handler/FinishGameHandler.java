package com.pr.gameclient.services.ws.handler;

import com.pr.gameclient.services.ws.handler.helpers.MessageHandler;
import com.pr.gameclient.services.ws.message.FinishGame;
import com.pr.gameclient.controller.ClientPresenter;
import jakarta.websocket.Session;

public class FinishGameHandler extends MessageHandler<FinishGame> {
    @Override
    public Class<FinishGame> getMessageClass() {
        return FinishGame.class;
    }

    @Override
    protected void handle(Session session, FinishGame object) {
        final boolean equals = ClientPresenter.getInstance().getLogin().equals(object.getWinnerLogin());

        ClientPresenter.getInstance().finishGame(equals);
    }
}
