module com.pr.gameclient {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;
    requires jakarta.websocket;
    requires org.glassfish.tyrus.client;

    opens com.pr.gameclient to javafx.fxml;
    exports com.pr.gameclient;
    exports com.pr.gameclient.controller;
    opens com.pr.gameclient.controller to javafx.fxml;
}
