package com.pr.gameclient;

import com.pr.gameclient.controller.MenuController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage)  throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Start.fxml"));
        Parent root = fxmlLoader.load();
        MenuController startWindowController = fxmlLoader.getController();
        startWindowController.setStage(stage);

        //WsService.start();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Dont get Caught");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
