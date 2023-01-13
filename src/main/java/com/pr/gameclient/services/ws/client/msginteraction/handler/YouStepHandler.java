package com.pr.gameclient.services.ws.client.msginteraction.handler;

import com.pr.gameclient.services.ws.common.msginteraction.generic.MessageHandler;
import com.pr.gameclient.services.ws.mvp.ClientPresenter;
import jakarta.websocket.Session;


public class YouStepHandler extends MessageHandler<YouStepHandler> {
    @Override
    public Class<YouStepHandler> getMessageClass() {
        return YouStepHandler.class;
    }

    @Override
    protected void handle(Session session, YouStepHandler object) {
        ClientPresenter.getInstance().myStepStart();
    }
}
