package com.pr.gameclient.services.ws.client.msginteraction.handler;

import com.pr.gameclient.services.ws.common.msginteraction.generic.MessageHandler;
import com.pr.gameclient.services.ws.common.msginteraction.message.FinishGame;
import com.pr.gameclient.services.ws.mvp.ClientPresenter;
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
