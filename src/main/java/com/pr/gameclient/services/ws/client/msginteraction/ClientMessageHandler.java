package com.pr.gameclient.services.ws.client.msginteraction;

import com.pr.gameclient.services.ws.client.msginteraction.handler.*;
import com.pr.gameclient.services.ws.common.msginteraction.UserInfoHelper;
import com.pr.gameclient.services.ws.common.msginteraction.generic.AllMessageHandler;
import com.pr.gameclient.services.ws.common.msginteraction.generic.MessageHandler;
import com.pr.gameclient.services.ws.common.msginteraction.message.*;

import java.util.Map;

public class ClientMessageHandler<Y extends MessageHandler> extends AllMessageHandler {
    @Override
    protected void initHandleMap(Map<String, MessageHandler> handleMap) {
        handleMap.put(LoginIndicatorMsg.class.getName(), new LoginIndicatorHandler());
        handleMap.put(UserInfoHelper.class.getName(), new UserInfoHelperHandler());
        handleMap.put(YouStepMsg.class.getName(), new YouStepHandler());
        handleMap.put(ReceiveScore.class.getName(), new ReceiveScoreHandler());
        handleMap.put(FinishGame.class.getName(), new FinishGameHandler());
        handleMap.put(StartGame.class.getName(), new StartGameHandler());
    }
}
