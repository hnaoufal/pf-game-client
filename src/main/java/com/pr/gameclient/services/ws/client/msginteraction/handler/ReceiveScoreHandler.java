package com.pr.gameclient.services.ws.client.msginteraction.handler;

import com.pr.gameclient.services.ws.common.msginteraction.generic.MessageHandler;
import com.pr.gameclient.services.ws.common.msginteraction.message.ReceiveScore;
import com.pr.gameclient.services.ws.mvp.ClientPresenter;
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
