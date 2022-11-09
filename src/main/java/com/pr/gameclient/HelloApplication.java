package com.pr.gameclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    private Stage stage;
    private Scene scene;

    public HelloApplication() {
        // default constructor
    }

    public Stage getStage() {
        return stage;
    }
    public Scene getScene() {
        return scene;
    }

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Start.fxml"));
            Parent root = loader.load();
            HelloController mainWindowController = loader.getController();
            mainWindowController.setPrimaryStage(stage);
            Scene scene = new Scene(root);
            stage.setTitle("");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}