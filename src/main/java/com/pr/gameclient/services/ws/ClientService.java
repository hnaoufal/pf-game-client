package com.pr.gameclient.services.ws;

import com.pr.gameclient.services.ws.task.ConnectionTask;
import javafx.concurrent.WorkerStateEvent;

import javafx.event.EventHandler;

public class ClientService {
    ClientEndpoint clientEndpoint;

    public void connect(String host, String login,
                        EventHandler<WorkerStateEvent> onSucceeded, EventHandler<WorkerStateEvent> onFailed) {
        ConnectionTask connectionTask = new ConnectionTask(host, login);

        connectionTask.setOnSucceeded(event -> {
            clientEndpoint = connectionTask.getValue();
            onSucceeded.handle(event);
        });

        connectionTask.setOnFailed(event -> {
                    onFailed.handle(event);
                    System.out.println(
                            "Unable to connect " +
                            connectionTask.getException()
                    );
                }
        );

        connectionTask.run();
    }

    public void sendText(String text) {
        clientEndpoint.sendText(text);
    }

    public void sendObject(Object object) {
        clientEndpoint.sendObject(object);
    }

}
