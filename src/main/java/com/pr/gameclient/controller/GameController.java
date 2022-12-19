package com.pr.gameclient.controller;

import javafx.animation.AnimationTimer;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    //Kollisionserkenner
    @FXML
    private AnchorPane scene;
    @FXML
    private ImageView policeman;
    @FXML
    private ImageView robber1;
    @FXML
    private ImageView robber2;
    @FXML
    private ImageView robber3;

    private final MoveController moveController = new MoveController();

    //Kollisionsprüfung wird zusammen mit einem AnimationTimer verwendet, der jeden Frame überprüft, ob es eine Kollision gegeben hat.
    AnimationTimer collisionTimer = new AnimationTimer() {
        public void handle(long timestamp) {
            collision(policeman, robber1, robber2, robber3);
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        moveController.move(scene, policeman);
        collisionTimer.start();
    }

    //Kollisionserkennung mithilfe der integrierten JavaFX-Funktion .intersects
    public void collision(ImageView policeman, ImageView collisionRobber1, ImageView collisionRobber2, ImageView collisionRobber3){
        if (policeman.getBoundsInParent().intersects(collisionRobber1.getBoundsInParent())){
            System.out.println("Kollision mit Raeuber 1");
        } else if (policeman.getBoundsInParent().intersects(collisionRobber2.getBoundsInParent())){
            System.out.println("Kollision mit Raeuber 2");
        } else if (policeman.getBoundsInParent().intersects(collisionRobber3.getBoundsInParent())){
            System.out.println("Kollision mit Raeuber 3");
        }
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

            //Wenn wir die gehoverte Karte erreichen, wird sie nach obenlinks herausgestellt und der Loop endet
            if (n == hoveredCard) {
                tt.setToY(-140);
                tt.setToX(count*(-50) - 75);
                tt.play();
                break;
            }

            //Alle Karten links von der gehoverten werden weiter nach links gerückt, damit sie sichtbar bleiben
            tt.setToX(count*(-50) - 75);
            tt.play();
            count++;
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
            tt.setToX(count*(-50)); // Das -50 ist, damit sich die Karten leicht überlappen
            tt.setToY(0); // Das holt die gehoverte Karte wieder runter zu den anderen
            tt.play();

            count++;
        }
    }
}
