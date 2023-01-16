module com.pr.gameclient {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;
    requires jakarta.websocket;
    requires org.glassfish.tyrus.client;
    requires com.fasterxml.jackson.databind;
    requires java.net.http;


    opens com.pr.gameclient to javafx.fxml, org.glassfish.tyrus.client, com.google.gson;
    exports com.pr.gameclient;
    exports com.pr.gameclient.controller;
    exports com.pr.gameclient.services.ws.client;
    exports com.pr.gameclient.services.ws.common;
    opens com.pr.gameclient.services.ws.common.msginteraction.message to com.google.gson;
    opens com.pr.gameclient.services.ws.common.msginteraction to com.google.gson;
    opens com.pr.gameclient.services.ws.common to com.google.gson;
    opens com.pr.gameclient.controller to javafx.fxml;
    exports com.pr.gameclient.models.game;
    exports com.pr.gameclient.models.user;
    opens com.pr.gameclient.models.game to javafx.fxml;
}
