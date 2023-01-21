package com.pr.gameclient.services.ws.handler;

import com.pr.gameclient.models.Context;
import com.pr.gameclient.controller.GameController;
import com.pr.gameclient.controller.MoveController;
import com.pr.gameclient.services.ws.handler.helpers.MessageHandler;
import com.pr.gameclient.services.ws.message.MoveMessage;
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
