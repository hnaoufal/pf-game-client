package com.pr.gameclient.services.ws.client.msginteraction.handler;

import com.pr.gameclient.Context;
import com.pr.gameclient.controller.GameController;
import com.pr.gameclient.controller.MoveController;
import com.pr.gameclient.services.ws.common.msginteraction.generic.MessageHandler;
import com.pr.gameclient.services.ws.common.msginteraction.message.ChatMessage;
import com.pr.gameclient.services.ws.common.msginteraction.message.MoveMessage;
import jakarta.websocket.Session;

public class MoveMessageHandler extends MessageHandler<MoveMessage> {
    @Override
    public Class<MoveMessage> getMessageClass() {
        return MoveMessage.class;
    }

    @Override
    protected void handle(Session session, MoveMessage object) {
        Context ctx = Context.getInstance();
        GameController controller = ctx.getGameController();
        MoveController moveController = controller.moveController;
        moveController.movePlayer(object.getMessage());
    }
}
