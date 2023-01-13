package com.pr.gameclient.services.ws.client.msginteraction.handler;

import com.pr.gameclient.services.ws.common.msginteraction.generic.MessageHandler;
import com.pr.gameclient.services.ws.common.msginteraction.message.LoginIndicatorMsg;
import com.pr.gameclient.services.ws.mvp.ClientPresenter;
import jakarta.websocket.Session;

public class LoginIndicatorHandler extends MessageHandler<LoginIndicatorMsg> {
    @Override
    public Class<LoginIndicatorMsg> getMessageClass() {
        return LoginIndicatorMsg.class;
    }

    @Override
    protected void handle(Session session, LoginIndicatorMsg object) {
        ClientPresenter.getInstance().checkLogIn(object);
    }
}
