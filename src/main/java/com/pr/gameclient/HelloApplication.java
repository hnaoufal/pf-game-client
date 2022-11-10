package com.pr.gameclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private Stage stage;

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage stage)  throws Exception {

        this.stage = stage;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Start.fxml"));

        Parent root = loader.load();
        HelloController startWindowController = loader.getController();
        startWindowController.setStage(stage);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Dont get Caught");
        stage.show();
    }
}