package com.pr.gameclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    @FXML
    private Stage stage;
    private Scene sceneSwitcher;
    private Parent root;
    private FXMLLoader fxmlLoader;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    // Zur Beschreibung
    @FXML
    protected void onButtonBeschreibung(ActionEvent event) throws IOException {

        fxmlLoader = new FXMLLoader(getClass().getResource("Description.fxml"));
        root = fxmlLoader.load();
        sceneSwitcher = stage.getScene();
        sceneSwitcher.setRoot(root);
    }

    // Zum Login
    @FXML
    public void onButtonZumLogin() throws IOException {

        fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
        root = fxmlLoader.load();
        sceneSwitcher = stage.getScene();
        sceneSwitcher.setRoot(root);
    }

    // Zur Registrierung
    @FXML
    public void onButtonZurRegistrierung() throws IOException {

        fxmlLoader = new FXMLLoader(getClass().getResource("Registry.fxml"));
        root = fxmlLoader.load();
        sceneSwitcher = stage.getScene();
        sceneSwitcher.setRoot(root);
    }

    // Zurück zum Startseite
    @FXML
    protected void onButtonZurStartseite() throws IOException {

        fxmlLoader = new FXMLLoader(getClass().getResource("Start.fxml"));
        root = fxmlLoader.load();
        sceneSwitcher = stage.getScene();
        sceneSwitcher.setRoot(root);
    }

    // Login und zur Seite "Settings" springen
    @FXML
    public void onButtonLogin() throws IOException {

        fxmlLoader = new FXMLLoader(getClass().getResource("Settings.fxml"));
        root = fxmlLoader.load();
        sceneSwitcher = stage.getScene();
        sceneSwitcher.setRoot(root);
    }

    // Registrierung und zur Seite "Settings" springen
    @FXML
    public void onButtonRegistrierung() throws IOException {

        fxmlLoader = new FXMLLoader(getClass().getResource("Settings.fxml"));
        root = fxmlLoader.load();
        sceneSwitcher = stage.getScene();
        sceneSwitcher.setRoot(root);
    }

    // Spiel beenden
    @FXML
    public void onButtonBeenden() throws IOException {
        System.exit(0);
    }
}