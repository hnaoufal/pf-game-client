package com.pr.gameclient.controller;

import com.pr.gameclient.models.Player;
import com.pr.gameclient.helpers.HTTPClient;
import com.pr.gameclient.models.assets.Point;
import com.pr.gameclient.models.places.Bank;
import com.pr.gameclient.models.places.Jeweler;
import com.pr.gameclient.models.places.Museum;
import com.pr.gameclient.models.places.Place;
import com.pr.gameclient.services.ws.message.ChatMessage;
import javafx.animation.AnimationTimer;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    private AnchorPane scene;
    @FXML
    private ImageView robber;
    @FXML
    private ImageView policeman;
    @FXML
    private ImageView bankIcon;
    @FXML
    private ImageView jewelerIcon;
    @FXML
    private ImageView museumIcon;
    @FXML
    private Button chatButton;
    @FXML
    private HBox robberIconPanel;
    @FXML
    private TextArea chat;
    @FXML
    private TextField chatInput;
    @FXML
    private Label scoreCounter;
    private String gameType = "police";
    public Player activePlayer = new Player();
    Bank bank = new Bank("assetSrc", new Point(0,0));
    Museum museum = new Museum("assetSrc", new Point(0,0));
    Jeweler jeweler = new Jeweler("assetSrc", new Point(0,0));
    int payCounter = 0;
    int imprisonedRobbers = 0;

    public final MoveController moveController = new MoveController();

    AnimationTimer collisionTimer = new AnimationTimer() {
        public void handle(long timestamp) {

            collision(robber, policeman, bankIcon, jewelerIcon, museumIcon);
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializePlaces();
        collisionTimer.start();
    }

    void initMovement(String gameType){
        if(gameType.equals("robber")){
            moveController.move(scene, robber, policeman);
        }
        else{
            moveController.move(scene, policeman, robber);
        }
    }

    // Kollisionserkennung mithilfe der integrierten JavaFX-Funktion .intersects
    public void collision(ImageView robber, ImageView policeman, ImageView collisionBank, ImageView collisionJeweler, ImageView collisionMuseum){
        Bounds robberBounds = robber.getBoundsInParent();
        Bounds policeBounds = policeman.getBoundsInParent();

        if (robberBounds.intersects(policeBounds) || policeBounds.intersects(robberBounds)){
            imprisonRobber();
            return;
        }

        if (robberBounds.intersects(collisionBank.getBoundsInParent())){
            increaseScore(bank);
        } else if (robberBounds.intersects(collisionJeweler.getBoundsInParent())){
            increaseScore(jeweler);
        } else if (robberBounds.intersects(collisionMuseum.getBoundsInParent())){
            increaseScore(museum);
        }

    }

    // Button "Zurück" zu den Settings
    @FXML
    public void onButtonZurueck(ActionEvent event) throws IOException {

        Parent root;
        Scene sceneSwitcher;

        root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
        sceneSwitcher = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(sceneSwitcher);
        stage.show();
    }

    // Button "Reset" um Spiel zurückzusetzen
    @FXML
    public void onButtonReset(ActionEvent event) throws IOException {

        robber.setLayoutX(100);
        robber.setLayoutY(210);
        scoreCounter.setText("0");
        //score.setText(String.valueOf(scoreCounter));
    }

    // Rückt die Karte, über der die Maus hovered nach oben und vergrößert sie. vorhergehende Karten rücken nach links
    // damit sie weiterhin sichtbar sind
    @FXML
    public void zoomCard(MouseEvent event) {

        //Die gehoverte Karte wird größer gemacht
        ImageView hoveredCard = (ImageView) event.getTarget();
        ScaleTransition st = new ScaleTransition(Duration.millis(500), hoveredCard);
        st.setToX(1.5);
        st.setToY(1.5);
        st.play();

        int count = 0; // Zählt bei der wievielten Karte auf der Hand (von links gezählt) wir im Loop sind.

        //Loop über alle Karten auf der Hand
        for (Node n : hoveredCard.getParent().getChildrenUnmodifiable()) {

            TranslateTransition tt = new TranslateTransition(Duration.millis(500), n);

            //Wenn wir die gehoverte Karte erreichen, wird sie nach oben links herausgestellt und der Loop endet
            if (n == hoveredCard) {
                tt.setToY(-50);
                tt.setToX(count*(-25) - 50);
                tt.play();
                break;
            }
        }
    }

    // Stellt den Orioginalzustand wieder her, wenn man nicht mehr über einer Karte hovered
    @FXML
    public void unZoomCard(MouseEvent event) {

        ImageView hoveredCard = (ImageView) event.getTarget();

        // Die gehoverte Karte wird wieder auf ihren normalen Scale geschrumpft
        ScaleTransition st = new ScaleTransition(Duration.millis(500), hoveredCard);
        st.setToX(1);
        st.setToY(1);
        st.play();

        int count = 0; // Zählt bei der wievielten Karte auf der Hand (von links gezählt) wir im Loop sind.

        // Alle Karten werden wieder auf ihre Ursprungsposition bewegt
        for (Node n : hoveredCard.getParent().getChildrenUnmodifiable()) {

            TranslateTransition tt = new TranslateTransition(Duration.millis(500), n);
            tt.setToX(count*(-10)); // Das -10 ist, damit sich die Karten leicht überlappen
            tt.setToY(0); // Das holt die gehoverte Karte wieder runter zu den anderen
            tt.play();

            count++;
        }
    }

    @FXML
    public void onChatSend() {
        String message = chatInput.getText();
        chat.appendText("Me: " + message + "\n");
        ClientPresenter.getInstance().sendToServer(new ChatMessage(message));
    }

    @FXML
    public void updateChat(String text) {
        chat.appendText("Opponent: " + text + "\n");
    }

    public void initializePlaces(){
        bank.setIcon(bankIcon);
        museum.setIcon(museumIcon);
        jeweler.setIcon(jewelerIcon);
    }

    public void increaseScore(Place place){
        if(payCounter == 10){
            payCounter = 0;
            activePlayer.setScore(activePlayer.getScore() + place.getMoneyValue());
            String currentScoreString = Integer.toString(activePlayer.getScore());
            scoreCounter.setText(currentScoreString);
        }else {
            payCounter++;
        }

    }

    public void imprisonRobber(){
        robber.relocate(100, 200);
        if(robber.getBoundsInParent().intersects(policeman.getBoundsInParent())) {
            robber.relocate(scene.getWidth() - 391, 200);
        }
        if(imprisonedRobbers > 5){
            imprisonedRobbers = 5;
        }
        Node imprisonedPortrait = robberIconPanel.getChildren().get(imprisonedRobbers);
        imprisonedPortrait.setOpacity(0.2);
        imprisonedRobbers++;
        if(imprisonedRobbers == 5){
            System.out.println("Spiel zuende!");
            robber.relocate(0,0);
            moveController.clearInputs();
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("GameOver.fxml"));
                Parent root;
                Scene sceneSwitcher;
                root = loader.load();

                MenuController controller1 = loader.getController();
                controller1.scoreDisplay.setText(scoreCounter.getText());
                sendHighScore();
                sceneSwitcher = new Scene(root);
                Stage stage = (Stage)  imprisonedPortrait.getScene().getWindow();
                stage.setScene(sceneSwitcher);
                stage.show();
            }catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void sendHighScore() throws Exception{
        String toSend = "{\"user\": \"" + activePlayer.getId() + "\"," +
                "\"points\": \"" + scoreCounter.getText() + "\"}";
        HTTPClient.post("http://localhost:8080/api/rankings", toSend);
    }
}
