package com.pr.gameclient.services.ws.handler;

import com.pr.gameclient.models.Context;
import com.pr.gameclient.controller.GameController;
import com.pr.gameclient.services.ws.handler.helpers.MessageHandler;
import com.pr.gameclient.services.ws.message.ChatMessage;
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
