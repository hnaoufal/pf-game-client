package com.pr.gameclient.controller;

import com.pr.gameclient.models.assets.Point;
import com.pr.gameclient.models.persons.Robber;
import com.pr.gameclient.models.places.Place;
import com.pr.gameclient.models.places.Supermarket;
import com.pr.gameclient.services.ws.common.msginteraction.message.ChatMessage;
import com.pr.gameclient.services.ws.mvp.ClientPresenter;
import javafx.animation.AnimationTimer;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    private AnchorPane scene;
    @FXML
    private ImageView robber;
    @FXML
    private ImageView bank;
    @FXML
    private ImageView jeweler;
    @FXML
    private ImageView museum;
    @FXML
    private Button chatButton;
    @FXML
    private TextArea chat;

    @FXML
    private ImageView robber1, robber1Icon;
    @FXML
    private ImageView robber2, robber2Icon;
    @FXML
    private ImageView robber3;
    @FXML
    private ImageView robber4;
    @FXML
    private ImageView robber5;
    @FXML
    private Circle CharacterSelectionCircle;

    private Robber selectedCharacter;

    private List<Robber> robberList = new ArrayList<>();

    private final MoveController moveController = new MoveController();

    AnimationTimer collisionTimer = new AnimationTimer() {
        public void handle(long timestamp) {

            collision(robber, bank, jeweler, museum);
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        generateCharacters();
        //moveController.move(scene, robber);
        //collisionTimer.start();
    }
    @FXML
    public void selectCharacter(MouseEvent event){
        ImageView target = (ImageView) event.getTarget();
        CharacterSelectionCircle.setCenterX(target.getLayoutX());
        for(int i = 0; i<robberList.size(); i++){
            if(robberList.get(i).getPortrait() == target){
                selectedCharacter = robberList.get(i);
            }
        }
    }

    @FXML
    public void moveCharacter(MouseEvent event){
        ImageView target = (ImageView) event.getTarget();
        selectedCharacter.move(target);

    }

    private void generateCharacters(){
        Robber robber01 = new Robber("robber1", "test", robber1, robber1Icon, 3, 5);
        selectedCharacter = robber01;
        robberList.add(robber01);
        Robber robber02 = new Robber("robber2", "test", robber2, robber2Icon, 3, 5);
        robberList.add(robber02);
    }

    // Kollisionserkennung mithilfe der integrierten JavaFX-Funktion .intersects
    public void collision(ImageView policeman, ImageView collisionBank, ImageView collisionJeweler, ImageView collisionMuseum){
        if (policeman.getBoundsInParent().intersects(collisionBank.getBoundsInParent())){
            System.out.println("Kollision mit Bank");
        } else if (policeman.getBoundsInParent().intersects(collisionJeweler.getBoundsInParent())){
            System.out.println("Kollision mit Juweliergeschaeft");
        } else if (policeman.getBoundsInParent().intersects(collisionMuseum.getBoundsInParent())){
            System.out.println("Kollision mit Museum");
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

        robber.setLayoutX(105);
        robber.setLayoutY(210);
        //scoreCounter = 0;
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

            //Alle Karten links von der gehoverten werden weiter nach links gerückt, damit sie sichtbar bleiben
            /*tt.setToX(count*(-25) - 50);
            tt.play();
            count++;*/
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
        ClientPresenter.getInstance().sendToServer(new ChatMessage(chat.getText()));
    }

    @FXML
    public void updateChat(String text) {
        chat.appendText(text);
    }
}
