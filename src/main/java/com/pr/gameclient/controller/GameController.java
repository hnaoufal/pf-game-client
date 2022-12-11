package com.pr.gameclient.controller;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    @FXML
    private AnchorPane scene;
    @FXML
    private ImageView policeman;

    private final MoveController moveController = new MoveController();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        moveController.move(scene, policeman);
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
