package com.pr.gameclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloController {

    @FXML
    private Stage stage;
    private Scene sceneSwitcher;
    private Parent root;

    public void setStage(Stage stage) {

        this.stage = stage;
    }

    // Zur Beschreibung
    @FXML
    protected void onButtonBeschreibung(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Description.fxml"));
        sceneSwitcher = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(sceneSwitcher);
        stage.show();
    }

    // Zum Login
    @FXML
    public void onButtonZumLogin(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        sceneSwitcher = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(sceneSwitcher);
        stage.show();
    }

    // Zur Registrierung
    @FXML
    public void onButtonZurRegistrierung(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Registry.fxml"));
        sceneSwitcher = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(sceneSwitcher);
        stage.show();
    }

    // Zurück zur Startseite
    @FXML
    protected void onButtonZurStartseite(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Start.fxml"));
        sceneSwitcher = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(sceneSwitcher);
        stage.show();
    }

    // Login und zur Seite "Settings" springen
    @FXML
    public void onButtonLogin(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        sceneSwitcher = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(sceneSwitcher);
        stage.show();
    }

    // Registrierung und zur Seite "Settings" springen
    @FXML
    public void onButtonRegistrierung(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        sceneSwitcher = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(sceneSwitcher);
        stage.show();
    }

    // Zu den Einstellungen des Officers
    @FXML
    public void onButtonOfficer(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Officer.fxml"));
        sceneSwitcher = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(sceneSwitcher);
        stage.show();
    }

    // Zu den Einstellungen des Robbers
    @FXML
    public void onButtonRobber(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Robber.fxml"));
        sceneSwitcher = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(sceneSwitcher);
        stage.show();
    }

    // Spiel beenden
    @FXML
    public void onButtonBeenden() {
        System.exit(0);
    }

    @FXML
    public void onButtonStart(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("RobberGame.fxml"));
        sceneSwitcher = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(sceneSwitcher);
        stage.show();
    }
}