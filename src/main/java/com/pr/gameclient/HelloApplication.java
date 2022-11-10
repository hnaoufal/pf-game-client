package com.pr.gameclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    //private Stage stage;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage)  throws IOException {

        //this.stage = stage;

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Start.fxml"));

        Parent root = fxmlLoader.load();
        HelloController startWindowController = fxmlLoader.getController();
        startWindowController.setStage(stage);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Dont get Caught");
        stage.show();
    }
}