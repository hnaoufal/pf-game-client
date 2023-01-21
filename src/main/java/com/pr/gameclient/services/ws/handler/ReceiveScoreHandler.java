package com.pr.gameclient.services.ws.handler;

import com.pr.gameclient.services.ws.handler.helpers.MessageHandler;
import com.pr.gameclient.services.ws.message.ReceiveScore;
import com.pr.gameclient.controller.ClientPresenter;
import jakarta.websocket.Session;

public class ReceiveScoreHandler extends MessageHandler<ReceiveScore> {
    @Override
    public Class<ReceiveScore> getMessageClass() {
        return ReceiveScore.class;
    }

    @Override
    protected void handle(Session session, ReceiveScore object) {
        ClientPresenter.getInstance().receiveScore(object.getScore());
    }
}
