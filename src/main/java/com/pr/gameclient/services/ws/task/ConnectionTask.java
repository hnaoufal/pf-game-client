package com.pr.gameclient.services.ws.task;


import com.pr.gameclient.services.ws.ClientEndpoint;
import com.pr.gameclient.helpers.StaticData;
import jakarta.websocket.*;
import javafx.concurrent.Task;
import org.glassfish.tyrus.client.ClientManager;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.TimeoutException;

public class ConnectionTask extends Task<ClientEndpoint> {
    private final String SERVER_ENDPOINT_ADDRESS;

    private final String username;

    public ConnectionTask(String serverHost, String username) {
        this.username = username;
        SERVER_ENDPOINT_ADDRESS = StaticData.getServerAdress(serverHost);
    }


    @Override
    protected ClientEndpoint call() throws IOException, TimeoutException, DeploymentException {
        ClientEndpoint clientEndpoint = new ClientEndpoint(username);
        ClientManager client = ClientManager.createClient();

        client.connectToServer(
            clientEndpoint,
            URI.create(SERVER_ENDPOINT_ADDRESS)
        );
        return clientEndpoint;
    }
}
