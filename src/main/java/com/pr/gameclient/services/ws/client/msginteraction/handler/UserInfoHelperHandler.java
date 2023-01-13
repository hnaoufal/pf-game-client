package com.pr.gameclient.services.ws.client.msginteraction.handler;

import com.pr.gameclient.services.ws.common.msginteraction.UserInfoHelper;
import com.pr.gameclient.services.ws.common.msginteraction.generic.MessageHandler;
import com.pr.gameclient.services.ws.mvp.ClientPresenter;
import jakarta.websocket.Session;

public class UserInfoHelperHandler extends MessageHandler<UserInfoHelper> {
    @Override
    public Class<UserInfoHelper> getMessageClass() {
        return UserInfoHelper.class;
    }

    @Override
    protected void handle(Session session, UserInfoHelper object) {
        UserInfoHelper.getInstance().getUserInfoList().clear();
        UserInfoHelper.getInstance().getUserInfoList().addAll(object.getUserInfoList());

        ClientPresenter.getInstance().refreshVisualizationUserInfo();
    }
}
