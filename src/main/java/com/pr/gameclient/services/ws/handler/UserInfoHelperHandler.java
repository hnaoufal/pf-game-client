package com.pr.gameclient.services.ws.handler;

import com.pr.gameclient.models.user.UserInfoHelper;
import com.pr.gameclient.services.ws.handler.helpers.MessageHandler;
import com.pr.gameclient.controller.ClientPresenter;
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
