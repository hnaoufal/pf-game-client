package com.pr.gameclient.controller;

import com.pr.gameclient.Context;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class MenuController {

    @FXML
    private Stage stage;
    private Scene sceneSwitcher;
    private Parent root;

    @FXML private TextField loginUser;
    @FXML private TextField loginPassword;
    @FXML private VBox LoginPageVbox;
    @FXML private TextField registerUser;
    @FXML private TextField registerPassword;
    @FXML private TextField registerEmail;
    @FXML private TextField registerPasswordRepeat;
    @FXML private VBox RegisterPageVbox;

    public void setStage(Stage stage) {

        this.stage = stage;
    }

    // Zur Beschreibung
    @FXML
    protected void onButtonAnleitung(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Instruction.fxml"));
        sceneSwitcher = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(sceneSwitcher);
        stage.show();
    }

    // Zur Seite "Login"
    @FXML
    public void onButtonZumLogin(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        sceneSwitcher = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(sceneSwitcher);
        stage.show();
    }

    // Zur Seite "Registrierung"
    @FXML
    public void onButtonZurRegistrierung(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("Registry.fxml"));
        sceneSwitcher = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(sceneSwitcher);
        stage.show();
    }

    // Login und zur Seite "Settings" springen
    @FXML
    public void onButtonLogin(ActionEvent event) throws IOException {
        try{
            LoginController LoginControl = new LoginController();
            LoginControl.LoginAction(loginUser.getText(), loginPassword.getText());
        }
        catch(Exception e){
            System.out.println(e.toString());
            if(LoginPageVbox.getChildren().size() == 1){ // Check, ob Label bereits von einem vorherigen Versuch da ist.
                LoginPageVbox.getChildren().add(new Label("Der angegebene Account existiert nicht!"));
            }
            return;
        }

        root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        sceneSwitcher = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(sceneSwitcher);
        stage.show();
    }

    // Registrierung und zur Seite "Settings" springen
    @FXML
    public void onButtonRegistrierung(ActionEvent event) throws IOException {
        // Check, ob alle Felder ausgefüllt sind und Anzeige Hinweis, falls nicht
        if(registerUser.getText().equals("") ||
           registerEmail.getText().equals("") ||
           registerPassword.getText().equals("")){
            Label labelMissingField = new Label("Bitte alle Felder vollständig ausfüllen!");
            labelMissingField.setTextFill(Color.RED);
            if(RegisterPageVbox.getChildren().size() == 2){ // Check, ob Label bereits von einem vorherigen Versuch da ist.
                RegisterPageVbox.getChildren().remove(1);
            }
            RegisterPageVbox.getChildren().add(labelMissingField);
            return;
        }
        // Check, ob die Passwortfelder übereinstimmen
        if(!registerPassword.getText().equals(registerPasswordRepeat.getText())){
            Label labelPasswordMatch = new Label("Passwörter sind nicht identisch!");
            labelPasswordMatch.setTextFill(Color.RED);
            if(RegisterPageVbox.getChildren().size() == 2){ // Check, ob Label bereits von einem vorherigen Versuch da ist.
                RegisterPageVbox.getChildren().remove(1);
            }
            RegisterPageVbox.getChildren().add(labelPasswordMatch);
            return;
        }
        // Versuch Benutzer anzulegen.
        // Response Code 200 = Benutzer erfolgreich angelegt
        // Exception = Benutzer existiert schon, oder anderer Fehler (Wird bisher nicht behandelt)
        try{
            LoginController LoginControl = new LoginController();
            LoginControl.RegisterAction(registerUser.getText(), registerEmail.getText(), registerPassword.getText());
            Label labelSuccess = new Label("Account erfolgreich angelegt!");
            labelSuccess.setTextFill(Color.GREEN);
            if(RegisterPageVbox.getChildren().size() == 2){ // Check, ob Label bereits von einem vorherigen Versuch da ist.
                RegisterPageVbox.getChildren().remove(1);
            }
            RegisterPageVbox.getChildren().add(labelSuccess);
        }
        catch(Exception e){
            System.out.println(e.toString());
            Label labelFail = new Label("Ein Account mit dieser Email existiert bereits!");
            labelFail.setTextFill(Color.RED);
            if(RegisterPageVbox.getChildren().size() == 2){ // Check, ob Label bereits von einem vorherigen Versuch da ist.
                RegisterPageVbox.getChildren().remove(1);
            }
            RegisterPageVbox.getChildren().add(labelFail);
        }
    }

    // Zu den Einstellungen des Officers
    @FXML
    public void onButtonOfficer(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Policeman.fxml"));
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

    // Button "Game" um Spiel zu starten
    @FXML
    public void onButtonGame(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Game_Alt.fxml"));
        root = loader.load();
        GameController controller = loader.getController();

        Context context = Context.getInstance();
        context.setLoader(loader);
        context.setGameController(controller);
        sceneSwitcher = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(sceneSwitcher);
        stage.show();
    }

    // Button "Zurück" zu den Start
    @FXML
    public void onButtonZurueckZumStart(ActionEvent event) throws IOException {

        root = FXMLLoader.load(getClass().getResource("/com/pr/gameclient/Start.fxml"));
        sceneSwitcher = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(sceneSwitcher);
        stage.show();
    }

    // Button "Zurück" zu den Settings
    @FXML
    public void onButtonZurueckZuSettings(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        sceneSwitcher = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(sceneSwitcher);
        stage.show();
    }

    // Spiel beenden
    @FXML
    public void onButtonEnde() {

        System.exit(0);
    }

    @FXML
    public void onButtonStart(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PoliceGame.fxml"));
        root = loader.load();
        GameController controller = loader.getController();

        Context context = Context.getInstance();
        context.setLoader(loader);
        context.setGameController(controller);
        sceneSwitcher = new Scene(root);
        sceneSwitcher.getRoot().requestFocus();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(sceneSwitcher);
        stage.show();
    }

    public void onButtonRanking(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(getClass().getResource("HighScore.fxml"));
        sceneSwitcher = new Scene(root);
        Stage stage = (Stage) ((Node)  actionEvent.getSource()).getScene().getWindow();
        stage.setScene(sceneSwitcher);
        stage.show();
    }
}
