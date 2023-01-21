package com.pr.gameclient.services.ws.handler;

import com.pr.gameclient.models.user.UserInfoHelper;
import com.pr.gameclient.services.ws.handler.helpers.AllMessageHandler;
import com.pr.gameclient.services.ws.handler.helpers.MessageHandler;
import com.pr.gameclient.services.ws.message.*;

import java.util.Map;

public class ClientMessageHandler<Y extends MessageHandler> extends AllMessageHandler {
    @Override
    protected void initHandleMap(Map<String, MessageHandler> handleMap) {
        handleMap.put(UserInfoHelper.class.getSimpleName(), new UserInfoHelperHandler());
        handleMap.put(ReceiveScore.class.getSimpleName(), new ReceiveScoreHandler());
        handleMap.put(FinishGame.class.getSimpleName(), new FinishGameHandler());
        handleMap.put(StartGame.class.getSimpleName(), new StartGameHandler());
        handleMap.put(ChatMessage.class.getSimpleName(), new ChatMessageHandler());
        handleMap.put(MoveMessage.class.getSimpleName(), new MoveMessageHandler());
    }
}
