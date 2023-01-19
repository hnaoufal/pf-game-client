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
        handleMap.put(UserInfoHelper.class.getSimpleName(), new UserInfoHelperHandler());
        handleMap.put(YouStepMsg.class.getSimpleName(), new YouStepHandler());
        handleMap.put(ReceiveScore.class.getSimpleName(), new ReceiveScoreHandler());
        handleMap.put(FinishGame.class.getSimpleName(), new FinishGameHandler());
        handleMap.put(StartGame.class.getSimpleName(), new StartGameHandler());
        handleMap.put(ChatMessage.class.getSimpleName(), new ChatMessageHandler());
        handleMap.put(MoveMessage.class.getSimpleName(), new MoveMessageHandler());
    }
}
