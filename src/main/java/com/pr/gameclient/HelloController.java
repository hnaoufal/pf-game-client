package com.pr.gameclient;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private FXMLLoader fxmlLoader;
    private Parent root;
    private Scene sceneSwitcher;
    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    // Zur Beschreibung
    @FXML
    protected void onButtonBeschreibung() throws Exception {

        fxmlLoader = new FXMLLoader(getClass().getResource("Description.fxml"));
        root = fxmlLoader.load();
        sceneSwitcher = stage.getScene();
        sceneSwitcher.setRoot(root);
    }

    // Zum Login
    @FXML
    public void onButtonZumLogin() throws Exception {

        fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        root = fxmlLoader.load();
        sceneSwitcher = stage.getScene();
        sceneSwitcher.setRoot(root);
    }

    // Zur Registrierung
    @FXML
    public void onButtonZurRegistrierung() throws Exception {

        fxmlLoader = new FXMLLoader(getClass().getResource("Registry.fxml"));
        root = fxmlLoader.load();
        sceneSwitcher = stage.getScene();
        sceneSwitcher.setRoot(root);
    }

    // Zurück zum Startfenster
    @FXML
    protected void onButtonStart() throws Exception {

        fxmlLoader = new FXMLLoader(getClass().getResource("Start.fxml"));
        root = fxmlLoader.load();
        sceneSwitcher = stage.getScene();
        sceneSwitcher.setRoot(root);
    }

    // Login und zum Fenster "Game" springen
    @FXML
    public void onButtonLogin() throws Exception {

        fxmlLoader = new FXMLLoader(getClass().getResource("Game.fxml"));
        root = fxmlLoader.load();
        sceneSwitcher = stage.getScene();
        sceneSwitcher.setRoot(root);
    }

    // Registrierung und zum Fenster "Game" springen
    @FXML
    public void onButtonRegistrierung() throws Exception {

        fxmlLoader = new FXMLLoader(getClass().getResource("Game.fxml"));
        root = fxmlLoader.load();
        sceneSwitcher = stage.getScene();
        sceneSwitcher.setRoot(root);
    }

    // Spiel beenden
    @FXML
    public void onButtonBeenden() throws Exception {
        System.exit(0);
    }
}