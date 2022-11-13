package com.pr.gameclient;

import javafx.animation.PathTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloController {

    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void setStage(Stage stage) {

        this.stage = stage;
    }

    // Zur Beschreibung
    @FXML
    protected void onButtonAnleitung(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Instruction.fxml"));
        scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Zur Seite "Login"
    @FXML
    public void onButtonZumLogin(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Zur Seite "Registrierung"
    @FXML
    public void onButtonZurRegistrierung(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Registry.fxml"));
        scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Login und zur Seite "Settings" springen
    @FXML
    public void onButtonLogin(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Registrierung und zur Seite "Settings" springen
    @FXML
    public void onButtonRegistrierung(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Zu den Einstellungen des Officers
    @FXML
    public void onButtonOfficer(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Officer.fxml"));
        scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Zu den Einstellungen des Robbers
    @FXML
    public void onButtonRobber(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Robber.fxml"));
        scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Button "Game" um Spiel zu starten
    @FXML
    public void onButtonGame(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Game.fxml"));
        scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Button "Zurück" zu den Start
    @FXML
    public void onButtonZurueckZumStart(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Start.fxml"));
        scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Button "Zurück" zu den Settings
    @FXML
    public void onButtonZurueckZuSettings(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Spiel beenden
    @FXML
    public void onButtonEnde() {

        System.exit(0);
    }
}