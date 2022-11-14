package com.pr.gameclient.controller;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.scene.Node;
import javafx.util.Duration;

public class RobberGameController {

    // Rückt die Karte, über der die Maus hovered nach oben und vergrößert sie. vorhergehende Karten rücken nach links
    // damit sie weiterhin sichtbar sind
    @FXML
    public void zoomCard(MouseEvent event) {

        //Die gehoverte Karte wird größer gemacht und herausgestellt
        ImageView hoveredCard = (ImageView) event.getTarget();

        ScaleTransition st = new ScaleTransition(Duration.millis(500), hoveredCard);
        st.setToX(1.5);
        st.setToY(1.5);
        st.play();


//        hoveredCard.getTransforms().add(new Translate(-110,-170,0));
//        hoveredCard.getTransforms().add(new Scale(1.5,1.5));

        int count = 0;
        //Alle Karten links von der gehoverten werden weiter nach links gerückt, damit sie sichtbar bleiben
        for (Node n : hoveredCard.getParent().getChildrenUnmodifiable()) { // Für alle Anderen Kinder der hbox in der die Karten sind
            if (n == hoveredCard) {
                TranslateTransition tt = new TranslateTransition(Duration.millis(500), hoveredCard);
                tt.setToX(count*(-50) - 75);
                tt.setToY(-140);
                tt.play();

                break; // Wenn wir die gehoverte Karte erreichen, hören wir auf
            }
//            n.getTransforms().add(new Translate(-110,0,0));
            TranslateTransition leftCards = new TranslateTransition(Duration.millis(500), n);
            leftCards.setToX(count*(-50) - 75);
            leftCards.play();
            count++;
        }

    }

    // Stellt den Orioginalzustand wieder her, wenn man nicht mehr über einer Karte hovered
    @FXML
    public void unZoomCard(MouseEvent event) {

        ImageView hoveredCard = (ImageView) event.getTarget();

        ScaleTransition st = new ScaleTransition(Duration.millis(500), hoveredCard);
        st.setToX(1);
        st.setToY(1);
        st.play();



        int count = 0;
        //Alle Transforms von allen Karten entfernen
        for (Node n : hoveredCard.getParent().getChildrenUnmodifiable()) {
            n.getTransforms().clear();

            TranslateTransition tt = new TranslateTransition(Duration.millis(500), n);
            tt.setToX(count*(-50));
            tt.setToY(0);
            tt.play();

            count++;
        }
    }

}
