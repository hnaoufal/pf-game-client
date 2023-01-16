package com.pr.gameclient.services.ws.client.msginteraction.handler;

import com.pr.gameclient.Context;
import com.pr.gameclient.controller.GameController;
import com.pr.gameclient.services.ws.common.msginteraction.generic.MessageHandler;
import com.pr.gameclient.services.ws.common.msginteraction.message.ChatMessage;
import jakarta.websocket.Session;

public class ChatMessageHandler extends MessageHandler<ChatMessage> {
    @Override
    public Class<ChatMessage> getMessageClass() {
        return ChatMessage.class;
    }

    @Override
    protected void handle(Session session, ChatMessage object) {
        Context ctx = Context.getInstance();
        GameController controller = ctx.getGameController();

        controller.updateChat(object.getMessage());
    }
}
