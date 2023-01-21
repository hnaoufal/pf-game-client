package com.pr.gameclient.controller;
import com.pr.gameclient.services.ws.ClientEndpoint;

public class ClientPresenter {
    private static final ClientPresenter presenter = new ClientPresenter();

    private ClientEndpoint clientEndpoint;

    public static ClientPresenter getInstance() {
        return presenter;
    }

    private ClientPresenter() { }



    public String getLogin() {
        return clientEndpoint.getLogin();
    }

    public void refreshVisualizationUserInfo() {
        // TBD
    }


    public void sendToServer(Object object) {
        clientEndpoint.sendObject(object);
    }

    public void setClientEndpoint(ClientEndpoint clientEndpoint) {
        this.clientEndpoint = clientEndpoint;
        // TBD
    }

    public void receiveScore(int score) {
        // TBD
    }

    public void finishGame(boolean isWinner) {
        // TBD
    }

    public void startGame() {
        // TBD
    }
}
