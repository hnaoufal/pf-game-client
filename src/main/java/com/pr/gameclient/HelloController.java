package com.pr.gameclient;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Stage stage;
    private Scene scene;
    private FXMLLoader fxmlLoader;
    private Parent root;

    public void setPrimaryStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    protected void onButtonAnleitung() {
        try {
            scene = stage.getScene();
            fxmlLoader = new FXMLLoader(getClass().getResource("Instructions.fxml"));
            root = fxmlLoader.load();
            scene.setRoot(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onButtonLogin() {

    }

    public void onButtonBeenden() {
        System.exit(0);
    }
}