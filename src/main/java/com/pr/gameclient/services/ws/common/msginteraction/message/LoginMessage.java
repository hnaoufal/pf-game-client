package com.pr.gameclient.services.ws.common.msginteraction.message;

public class LoginMessage {
    private String login;

    public LoginMessage(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
