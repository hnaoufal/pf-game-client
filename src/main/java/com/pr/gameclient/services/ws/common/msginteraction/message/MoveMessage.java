package com.pr.gameclient.services.ws.common.msginteraction.message;

public class MoveMessage {
    private String message;

    public MoveMessage(String x, String y) {
        this.message = x + "/" + y;
    }

    public MoveMessage(Double x, Double y) {
        this.message = x + "/" + y;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String x, String y) {
        this.message = x + "/" + y;
    }
}
